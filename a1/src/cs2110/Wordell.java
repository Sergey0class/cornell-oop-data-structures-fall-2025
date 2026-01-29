package cs2110;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Console implementation of the popular game "Wordle".
 */
public class Wordell {

    private static ArrayList<Character> grayChar;
    private static int[] greenChar;
    private static final Pattern PATTERN = Pattern.compile("[A-Z]");
    private static final int GRAY = 0;
    private static final int YELLOW = 1;
    private static final int GREEN = 2;
    private static final int WORD_LENGTH = 5;
    private static final int MAXIMUM_ATTEMPTS = 6;
    private static final int COUNT_ASCII_SYMBOL = 256;

    /**
     * Returns a random valid word from the "words.txt" file.
     */
    static String getRandomValidWord() throws IOException {
        String[] validWords = Files.readString(Path.of("words.txt")).split("\n");
        Random rand = new Random();
        return validWords[rand.nextInt(validWords.length)];
    }

    /**
     * Helper method to format a character as a green tile.
     */
    static String greenTile(char c) {
        assert 'A' <= c && c <= 'Z';
        return "\u001B[102m " + c + " \u001B[0m ";
    }

    /**
     * Helper method to format a character as a yellow tile.
     */
    static String yellowTile(char c) {
        assert 'A' <= c && c <= 'Z';
        return "\u001B[103m " + c + " \u001B[0m ";
    }

    /**
     * Helper method to format a character as a gray tile.
     */
    static String grayTile(char c) {
        assert 'A' <= c && c <= 'Z';
        return "\u001B[47m " + c + " \u001B[0m ";
    }

    /**
     * Checks if the user's guess is valid.
     * Criteria:
     * 1. Length must be exactly 5 characters.
     * 2. All characters must be uppercase letters A-Z.
     */
    static boolean isValidGuess(String guess) {
        assert guess != null;

        if (guess.length() != WORD_LENGTH) {
            System.out.println("Your guess must have 5 letters. Try again.");
            return false;
        }

        for (char c : guess.toCharArray()) {

            String letter = String.valueOf(c);
            boolean falseSymbol = PATTERN.matcher(letter).matches();

            if (!falseSymbol) {
                System.out.println("Your guess cannot include the character '" + letter + "'. Try again.");
                return false;
            }
        }

        return true;
    }

    /**
     * Prints the guess to the console as colored tiles.
     */
    static void printGuessOutput(String guess, int[] colors) {

        StringBuilder wordCollor = new StringBuilder();

        for (int i = 0; i < colors.length; i++) {

            char colorSymbol = guess.charAt(i);

            if (colors[i] == GRAY) {
                wordCollor.append(grayTile(colorSymbol));
            } else if (colors[i] == YELLOW) {
                wordCollor.append(yellowTile(colorSymbol));
            } else {
                wordCollor.append(greenTile(colorSymbol));
            }

        }

        System.out.println(wordCollor.toString());

    }

    /**
     * Generates an array representing the colors of the tiles for a guess.
     * Compares the guess against the target word.
     *
     * Rules:
     * - Green (2): The letter is in the correct spot.
     * - Yellow (1): The letter is in the word but in the wrong spot (if not already
     * used for green).
     * - Gray (0): The letter is not in the word (or excess duplicates).
     */
    public static int[] getColorArray(String guess, String word) {

        int[] color = new int[WORD_LENGTH];
        int[] countLetters = new int[COUNT_ASCII_SYMBOL];

        for (int i = 0; i < word.length(); i++) {
            countLetters[word.charAt(i)]++;
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                color[i] = GREEN;
                countLetters[guess.charAt(i)]--;
            }
        }

        for (int k = 0; k < WORD_LENGTH; k++) {
            if (color[k] == GREEN) {
                continue;
            }

            if (countLetters[guess.charAt(k)] > 0) {
                color[k] = YELLOW;
                countLetters[guess.charAt(k)]--;
            }
        }

        return color;
    }

    /**
     * Main game loop (Standard Mode).
     * The player has 6 attempts to guess the word.
     */
    static void play(String word, Scanner sc) {

        int attempt = 1;

        while (true) {

            if (attempt > MAXIMUM_ATTEMPTS) {
                System.out.println("Better luck next time. The word was " + word + ".");
                break;
            }

            System.out.print(attempt + ". Enter a guess: ");

            String say = sc.nextLine().toUpperCase();

            if (!isValidGuess(say)) {
                continue;
            }

            printGuessOutput(say, getColorArray(say, word));

            if (say.equals(word)) {
                System.out.println("Congratulations! You won in " + attempt + " guesses.");
                break;
            }

            attempt++;

        }
    }

    /**
     * Updates the global state arrays (greenChar and grayChar) for Hard Mode.
     * Records which letters are confirmed green and which are confirmed absent
     * (gray).
     */
    public static void setArrayGreenAndGrayChar(String word, int[] a) {

        for (int i = 0; i < WORD_LENGTH; i++) {

            if (a[i] == GREEN) {
                greenChar[i] = GREEN;
            }

            if (a[i] == GRAY) {

                boolean canBan = true;
                char symbolIndexI = word.charAt(i);

                for (int j = 0; j < WORD_LENGTH; j++) {
                    if (word.charAt(j) == symbolIndexI && a[j] != GRAY) {
                        canBan = false;
                        break;
                    }
                }

                if (canBan) {
                    grayChar.add(symbolIndexI);
                }
            }
        }
    }

    /**
     * Checks if the current guess violates Hard Mode constraints.
     *
     * Constraints:
     * 1. Cannot use letters that were previously confirmed as gray (absent).
     * 2. Must reuse green letters in the same position.
     */
    public static boolean isTrueDuplicates(String word, int[] a) {

        for (int i = 0; i < WORD_LENGTH; i++) {

            if (grayChar.contains(word.charAt(i))) {
                return true;
            }

            if (greenChar[i] == GREEN && a[i] != GREEN) {
                return true;
            }
        }

        return false;
    }

    /**
     * Game loop for Hard Mode.
     * In Hard Mode, any revealed hints must be used in subsequent guesses.
     */
    static void playHardMode(String word, Scanner sc) {

        Wordell.grayChar = new ArrayList<>();
        Wordell.greenChar = new int[WORD_LENGTH];

        int attempt = 1;
        String oldWord = "";

        while (true) {

            if (attempt > MAXIMUM_ATTEMPTS) {
                System.out.println("Better luck next time. The word was " + word + ".");
                break;
            }

            System.out.print(attempt + ". Enter a guess: ");

            String say = sc.nextLine().toUpperCase();

            if (!isValidGuess(say)) {
                continue;
            }

            int[] countColor = getColorArray(say, word);

            if (say.equals(word)) {
                printGuessOutput(say, countColor);
                System.out.println("Congratulations! You won in " + attempt + " guesses.");
                break;
            }

            if (isTrueDuplicates(say, countColor)) {
                System.out.println("Your guess conflicts with information from the guess " + oldWord + ". Try again.");
                continue;
            }

            setArrayGreenAndGrayChar(say, countColor);

            printGuessOutput(say, countColor);

            oldWord = say;
            attempt++;

        }

    }

    public static void main(String[] args) throws IOException {
        boolean hardMode = (args.length == 1 && args[0].equals("hard"));

        try (Scanner sc = new Scanner(System.in)) {
            if (hardMode) {
                playHardMode(getRandomValidWord(), sc);
            } else {
                play(getRandomValidWord(), sc);
            }
        }
    }
}
package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HardModeTest {

        /*
         * *****************************************************************************
         * **************
         * The code at the top of this file is used to capture the console output, so we
         * can check
         * that it is correct.
         */

        /**
         * The original `System.out`.
         */
        PrintStream systemOut;

        /**
         * Replacement for `System.out` during test execution.
         */
        PrintStream out;
        ByteArrayOutputStream outBytes;

        @BeforeEach
        void setUpSimulator() {
                outBytes = new ByteArrayOutputStream();
                out = new PrintStream(outBytes);
                systemOut = System.out;
                System.setOut(out);
                clearOutputStream();
        }

        /**
         * Resets the output stream so we can capture the print output from processing
         * one command
         */
        void clearOutputStream() {
                out.flush();
                outBytes.reset();
        }

        @AfterEach
        void restoreOutput() {
                out.close();
                System.setOut(systemOut);
        }

        /*
         * *****************************************************************************
         * **************
         * Here is where the tests begin.
         */

        /**
         * Returns a String array whose entries are lines of the console from `play()`.
         */
        String[] reconstructConsole(String inputs) {
                out.flush();
                String[] outLines = outBytes.toString().split(System.lineSeparator());
                String[] inLines = inputs.split("\n");
                assert outLines.length == inLines.length + 1;
                String[] console = new String[2 * outLines.length - 1];
                for (int i = 0; i < outLines.length - 1; i++) {
                        int splitIndex = outLines[i].indexOf(":") + 2; // separate prompt from message
                        console[2 * i] = outLines[i].substring(0, splitIndex) + inLines[i];
                        console[2 * i + 1] = outLines[i].substring(splitIndex);
                }
                console[console.length - 1] = outLines[outLines.length - 1];
                return console;
        }

        @DisplayName("Logic Check: Excess letter should not block future valid NON-WINNING guesses.")
        @Test
        void testExcessLetterLogicReal() {
                // Target: ABBEY
                // 1. BOBBY -> excess B gets added to the ban list (in the incorrect
                // implementation).
                // 2. TUBBY -> valid word, contains B, but we haven't won yet.
                // The code checks isTrueDuplicates, sees B in the ban list, and erroneously
                // blocks the move.

                String inputs = "BOBBY\nTUBBY\nABBEY";
                Wordell.playHardMode("ABBEY", new Scanner(inputs));

                String[] output = reconstructConsole(inputs);

                boolean foundConflictError = false;
                // Check for an error specifically after entering TUBBY
                for (String line : output) {
                        if (line.contains("conflicts with information")) {
                                foundConflictError = true;
                        }
                }

                // This test will fail if your code blocks TUBBY
                assertFalse(foundConflictError,
                                "Error: Your code banned the word TUBBY because of the letter B, even though it exists in the word!");
        }

        @DisplayName("A full game of Wordell has the correct console outputs in hard mode.")
        @Test
        void testFullGame() {
                String inputs = "least\nflash\nclasp";
                Wordell.play("CLASP", new Scanner(inputs));

                String[] expected = new String[] {
                                "1. Enter a guess: least",
                                "\u001B[103m L \u001B[0m \u001B[47m E \u001B[0m \u001B[102m A \u001B[0m "
                                                + "\u001B[102m S \u001B[0m \u001B[47m T \u001B[0m ",
                                "2. Enter a guess: flash",
                                "\u001B[47m F \u001B[0m \u001B[102m L \u001B[0m \u001B[102m A \u001B[0m "
                                                + "\u001B[102m S \u001B[0m \u001B[47m H \u001B[0m ",
                                "3. Enter a guess: clasp",
                                "\u001B[102m C \u001B[0m \u001B[102m L \u001B[0m \u001B[102m A \u001B[0m "
                                                + "\u001B[102m S \u001B[0m \u001B[102m P \u001B[0m ",
                                "Congratulations! You won in 3 guesses."
                };

                assertArrayEquals(expected, reconstructConsole(inputs));
        }

        @DisplayName("Any invalid guess in \"normal mode\" should also be invalid in hard mode.")
        @Test
        void testNormalInvalidHard() {
                String inputs = "HELLO!\nHELO!\nHELLO";
                Wordell.playHardMode("HELLO", new Scanner(inputs));

                String[] expected = new String[] {
                                "1. Enter a guess: HELLO!",
                                "Your guess must have 5 letters. Try again.",
                                "1. Enter a guess: HELO!",
                                "Your guess cannot include the character '!'. Try again.",
                                "1. Enter a guess: HELLO",
                                "\u001B[102m H \u001B[0m \u001B[102m E \u001B[0m \u001B[102m L \u001B[0m "
                                                + "\u001B[102m L \u001B[0m \u001B[102m O \u001B[0m ",
                                "Congratulations! You won in 1 guesses."
                };

                assertArrayEquals(expected, reconstructConsole(inputs));
        }

        @DisplayName("WHEN a user enters a guess with a gray letter tile AND then enters another guess "
                        + "with the same gray letter, THEN the game will deem that later guess invalid, print "
                        + "the correct message, and prompt for a new guess without the guess number increasing.")
        @Test
        void testReusedGrayInvalid() {
                // same position
                String inputs = "PUPPY\nTURNS\nHELLO";
                Wordell.playHardMode("HELLO", new Scanner(inputs));

                String[] expected = new String[] {
                                "1. Enter a guess: PUPPY",
                                "\u001B[47m P \u001B[0m \u001B[47m U \u001B[0m \u001B[47m P \u001B[0m "
                                                + "\u001B[47m P \u001B[0m \u001B[47m Y \u001B[0m ",
                                "2. Enter a guess: TURNS",
                                "Your guess conflicts with information from the guess PUPPY. Try again.",
                                "2. Enter a guess: HELLO",
                                "\u001B[102m H \u001B[0m \u001B[102m E \u001B[0m \u001B[102m L \u001B[0m "
                                                + "\u001B[102m L \u001B[0m \u001B[102m O \u001B[0m ",
                                "Congratulations! You won in 2 guesses."
                };
                assertArrayEquals(expected, reconstructConsole(inputs));
                outBytes.reset();

                // different position
                inputs = "PUPPY\nTRUCK\nHELLO";
                Wordell.playHardMode("HELLO", new Scanner(inputs));

                expected = new String[] {
                                "1. Enter a guess: PUPPY",
                                "\u001B[47m P \u001B[0m \u001B[47m U \u001B[0m \u001B[47m P \u001B[0m "
                                                + "\u001B[47m P \u001B[0m \u001B[47m Y \u001B[0m ",
                                "2. Enter a guess: TRUCK",
                                "Your guess conflicts with information from the guess PUPPY. Try again.",
                                "2. Enter a guess: HELLO",
                                "\u001B[102m H \u001B[0m \u001B[102m E \u001B[0m \u001B[102m L \u001B[0m "
                                                + "\u001B[102m L \u001B[0m \u001B[102m O \u001B[0m ",
                                "Congratulations! You won in 2 guesses."
                };
                assertArrayEquals(expected, reconstructConsole(inputs));
        }

        @DisplayName("WHEN a user enters a guess with a green letter tile AND does not include that "
                        + "letter in that position in a later guess, THEN the game will deem that later guess "
                        + "invalid, print the correct message, and prompt for a new guess without the guess "
                        + "number increasing.")
        @Test
        void testMissingGreenInvalid() {
                // not present at all
                String inputs = "HAPPY\nTUNIC\nHELLO";
                Wordell.playHardMode("HELLO", new Scanner(inputs));

                String[] expected = new String[] {
                                "1. Enter a guess: HAPPY",
                                "\u001B[102m H \u001B[0m \u001B[47m A \u001B[0m \u001B[47m P \u001B[0m "
                                                + "\u001B[47m P \u001B[0m \u001B[47m Y \u001B[0m ",
                                "2. Enter a guess: TUNIC",
                                "Your guess conflicts with information from the guess HAPPY. Try again.",
                                "2. Enter a guess: HELLO",
                                "\u001B[102m H \u001B[0m \u001B[102m E \u001B[0m \u001B[102m L \u001B[0m "
                                                + "\u001B[102m L \u001B[0m \u001B[102m O \u001B[0m ",
                                "Congratulations! You won in 2 guesses."
                };
                assertArrayEquals(expected, reconstructConsole(inputs));
                outBytes.reset();

                // present only at a different position
                inputs = "HAPPY\nWITCH\nHELLO";
                Wordell.playHardMode("HELLO", new Scanner(inputs));

                expected = new String[] {
                                "1. Enter a guess: HAPPY",
                                "\u001B[102m H \u001B[0m \u001B[47m A \u001B[0m \u001B[47m P \u001B[0m "
                                                + "\u001B[47m P \u001B[0m \u001B[47m Y \u001B[0m ",
                                "2. Enter a guess: WITCH",
                                "Your guess conflicts with information from the guess HAPPY. Try again.",
                                "2. Enter a guess: HELLO",
                                "\u001B[102m H \u001B[0m \u001B[102m E \u001B[0m \u001B[102m L \u001B[0m "
                                                + "\u001B[102m L \u001B[0m \u001B[102m O \u001B[0m ",
                                "Congratulations! You won in 2 guesses."
                };
                assertArrayEquals(expected, reconstructConsole(inputs));
        }

        @DisplayName("If a letter is present in the word but guessed in excess (marked gray), it should NOT be banned globally.")
        @Test
        void testExcessLetterNotBanned() {
                // Target word: ABBEY (two B's)
                // User guess: BOBBY (three B's)
                // Colors: B(1), O(0), B(2), B(0), Y(2)
                // The third B in BOBBY will be gray because ABBEY only has two B's.

                String inputs = "BOBBY\nABBEY";
                // Second attempt - ABBEY (the correct word).
                // If the logic is flawed, the code will reject this because 'B' was added to
                // grayChar.

                Wordell.playHardMode("ABBEY", new Scanner(inputs));

                String[] output = reconstructConsole(inputs);

                // Verify that the game did NOT output a conflict error when entering the
                // correct word
                boolean foundConflictError = false;
                for (String line : output) {
                        if (line.contains("conflicts with information")) {
                                foundConflictError = true;
                        }
                }

                assertFalse(foundConflictError,
                                "Error: The letter B was globally banned, even though it exists in the word! We could not win.");
        }
}

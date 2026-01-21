package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecsTest {

    /*****  Uppercase At  *****/

    @DisplayName("WHEN tie is in the middle of string, returns the first of winners")
    @Test
    void testTieInMiddle() {
        String test = "z aabb";
        assertEquals('a', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN there are the most characters at the end of a line, "
            + "THEN this symbol returns.")
    @Test
    void testmostFrequentLotsCharsLast() {

        String test = "baa";

        assertEquals('a', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN there are the most characters at the beginning of the line, "
            + "THEN this symbol returns.")
    @Test
    void testmostFrequentLotsCharsFirst() {

        String test = "aab";

        assertEquals('a', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN there is one character in a string, "
            + "THEN only he returns.")
    @Test
    void testmostFrequentOneChar() {

        String test = "a";

        assertEquals('a', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN a string has the same number of characters, "
            + "THEN the very first of the line is returned.")
    @Test
    void testmostFrequentEqualsCharsFirstandLast() {

        String test = "abba";

        assertEquals('a', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN a string has the same number of characters, "
            + "THEN the very first of the line is returned.")
    @Test
    void testmostFrequentEqualsChars() {

        String test = "home";

        assertEquals('h', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN there are many repeated characters in a string, "
            + "THEN the symbol that occurs more often returns.")
    @Test
    void testmostFrequentLotsChars() {

        String test = "abcceryyyioppppll";

        assertEquals('p', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN there are multiple identical characters in a string, "
            + "THEN this symbol returns.")
    @Test
    void testmostFrequentTwoChar() {

        String test = "wood";

        assertEquals('o', Specs.mostFrequent(test));
    }

    @DisplayName("WHEN the smallest number in the very first index, "
            + "THEN the array doesn't change.")
    @Test
    void testSelectSmallestFirstMinValue() {

        int[] test = {1, 2, 3};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{1, 2, 3}, test);
    }

    @DisplayName("WHEN an array has the lowest number in the most recent index, "
            + "THEN it shifts to the very first index.")
    @Test
    void testSelectSmallestLastMinValue() {

        int[] test = {3, 2, 1};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{1, 3, 2}, test);
    }

    @DisplayName("WHEN there is a single value in an array, "
            + "THEN this value will remain in the array.")
    @Test
    void testSelectSmallestOneValue() {

        int[] test = {2};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{2}, test);
    }

    @DisplayName("WHEN all the values in an array are the same, "
            + "THEN the array will remain the same.")
    @Test
    void testSelectSmallestNoMinValue() {

        int[] testOne = {2, 2, 2, 2, 2, 2};
        int[] testTwo = {-2, -2, -2, -2, -2, -2};
        int[] testThree = {0, 0, 0, 0, 0, 0};

        Specs.selectSmallest(testOne);
        Specs.selectSmallest(testTwo);
        Specs.selectSmallest(testThree);

        assertArrayEquals(new int[]{2, 2, 2, 2, 2, 2}, testOne);
        assertArrayEquals(new int[]{-2, -2, -2, -2, -2, -2}, testTwo);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0}, testThree);
    }

    @DisplayName("WHEN the minimum number in the array is 0, "
            + "THEN it shifts to the first index.")
    @Test
    void testSelectSmallestZeroMinValue() {

        int[] testOne = {2, 2, 0, 1, 4, 5};

        Specs.selectSmallest(testOne);

        assertArrayEquals(new int[]{0, 2, 2, 1, 4, 5}, testOne);
    }

    @DisplayName("WHEN the minimum number in the array is negative, "
            + "THEN it shifts to the first index.")
    @Test
    void testSelectSmallestNegativeMinValue() {

        int[] test = {2, 2, 3, -1, 4, 5};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{-1, 2, 2, 3, 4, 5}, test);
    }

    @DisplayName("WHEN there are two identical minimum numbers in an array, "
            + "THEN first of them shifts to the first index.")
    @Test
    void testSelectSmallestTwoMinValue() {

        int[] test = {2, 2, 1, 1, 4, 5};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{1, 2, 2, 1, 4, 5}, test);
    }

    @DisplayName("WHEN an array has one minimum value, "
            + "THEN it shifts to the first index.")
    @Test
    void testSelectSmallestOneMinValue() {

        int[] test = {2, 2, 3, 1, 4, 5};

        Specs.selectSmallest(test);

        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5}, test);
    }

    @DisplayName("WHEN there are no zero places in the array to shift to the left, "
            + "THEN the method does not shift values to the left.")
    @Test
    void testNoCondenseArrayInt() {

        int[] testOne = {1, -2, 3, 0, 0, 0};
        int[] testTwo = {-1, 1, -1, 0, 0, 0};
        int[] testThree = {-1, 2, -3, 4, 5, 6};

        assertEquals(3, Specs.condense(testOne));
        assertEquals(3, Specs.condense(testTwo));
        assertEquals(6, Specs.condense(testThree));

        assertTrue(Specs.condenseTestHelper(new int[]{1, -2, 3}, testOne, 3));
        assertTrue(Specs.condenseTestHelper(new int[]{-1, 1, -1}, testTwo, 3));
        assertTrue(Specs.condenseTestHelper(new int[]{-1, 2, -3, 4, 5, 6}, testThree, 6));
    }

    @DisplayName("WHEN there are 0's in the array, "
            + "THEN the method shifts non-zero values to the left in their place.")
    @Test
    void testCondenseArrayInt() {

        int[] testOneArray = new int[]{0, 0, 0, 1, 2, 3};
        int[] testTwoArray = new int[]{0, 1};
        int[] testThreeArray = new int[]{0, 2, 0, 1, 0, 0};
        int[] testFourArray = new int[]{1, 1, 1, 0, 2, 3};
        int[] testFiveArray = new int[]{0, 0, 0, 0, 0, 0};
        int[] testSixArray = new int[]{0, 0, 0, 1, 2, 3, 4, 5, 6};

        assertEquals(3, Specs.condense(testOneArray));
        assertEquals(1, Specs.condense(testTwoArray));
        assertEquals(2, Specs.condense(testThreeArray));
        assertEquals(5, Specs.condense(testFourArray));
        assertEquals(0, Specs.condense(testFiveArray));
        assertEquals(6, Specs.condense(testSixArray));

        assertTrue(Specs.condenseTestHelper(new int[]{1, 2, 3}, testOneArray, 3));
        assertTrue(Specs.condenseTestHelper(new int[]{1}, testTwoArray, 1));
        assertTrue(Specs.condenseTestHelper(new int[]{2, 1}, testThreeArray, 2));
        assertTrue(Specs.condenseTestHelper(new int[]{1, 1, 1, 2, 3}, testFourArray, 5));
        assertTrue(Specs.condenseTestHelper(new int[]{}, testFiveArray, 0));
        assertTrue(Specs.condenseTestHelper(new int[]{1, 2, 3, 4, 5, 6}, testSixArray, 6));
    }

    @DisplayName("WHEN the prefix is the word itself, "
            + " THEN the method returns the entire word.")
    @Test
    void testLongestCommonPrefixFullWord() {

        String testPrefOne = "test";
        String testPrefTwo = "testing";
        String testPrefThree = "examination";
        String testPrefFour = "examination";
        String testPrefFive = "a";
        String testPrefSix = "a";

        String actualOne = Specs.longestCommonPrefix(testPrefOne, testPrefTwo);
        String actualTwo = Specs.longestCommonPrefix(testPrefThree, testPrefFour);
        String actualThree = Specs.longestCommonPrefix(testPrefFive, testPrefSix);

        assertEquals("test", actualOne);
        assertEquals("examination", actualTwo);
        assertEquals("a", actualThree);
    }

    @DisplayName("WHEN two strings do not have the same prefix "
            + "THEN the method returns an empty string.")
    @Test
    void testLongestCommonPrefixNoEquals() {

        String testPrefOne = "boy";
        String testPrefTwo = "girl";
        String testPrefThree = "Wood";
        String testPrefFour = "woods";
        String testPrefFive = "a";
        String testPrefSix = "b";

        String actualOne = Specs.longestCommonPrefix(testPrefOne, testPrefTwo);
        String actualTwo = Specs.longestCommonPrefix(testPrefThree, testPrefFour);
        String actualThree = Specs.longestCommonPrefix(testPrefFive, testPrefSix);

        assertEquals("", actualOne);
        assertEquals("", actualTwo);
        assertEquals("", actualThree);
    }

    @DisplayName(
            "WHEN two strings have the same prefix, "
                    + "THEN the method returns it.")
    @Test
    void testLongestCommonPrefixEquals() {

        String testPrefOne = "schoolboy";
        String testPrefTwo = "schoolgirl";
        String testPrefThree = "houseelf";
        String testPrefFour = "how";
        String testPrefFive = "ahshdfshjdKLFKLGJLKFK";
        String testPrefSix = "ahshdfshjdLR;KY;RT";

        String actualOne = Specs.longestCommonPrefix(testPrefOne, testPrefTwo);
        String actualTwo = Specs.longestCommonPrefix(testPrefThree, testPrefFour);
        String actualThree = Specs.longestCommonPrefix(testPrefFive, testPrefSix);

        assertEquals("school", actualOne);
        assertEquals("ho", actualTwo);
        assertEquals("ahshdfshjd", actualThree);
    }

    @DisplayName(
            "WHEN there is one number in the array — 0, "
                    + " THEN the same number is returned.")
    @Test
    void testArrayOneValueZero() {
        double[] arr = {0};

        assertEquals(0, Specs.mean(arr));
    }

    @DisplayName(
            "WHEN there is one positive or negative number in the array, "
                    + " THEN the same number is returned.")
    @Test
    void testArrayOneValue() {
        double[] positiveValue = {46};
        double[] negativeValue = {-46};

        assertEquals(46, Specs.mean(positiveValue));
        assertEquals(-46, Specs.mean(negativeValue));
    }

    @DisplayName(
            "WHEN there is more than one number in the array,"
                    + "THEN their average value is returned.")
    @Test
    void testAverageValue() {
        double[] arr = {4, 6, -6};
        double actual = Specs.mean(arr);
        double delta = 1.0 / 1000;

        assertEquals(1.333333333333333, actual, delta);
    }

    @DisplayName(
            "WHEN the absolute values of the largest positive number and the negative one are equal, "
                    + "THEN either of them is returned.")
    @Test
    void testMaxPositiveAndNegativeNumber() {
        int[] arr = {4, 6, -6};
        assertEquals(6, Math.abs(Specs.maximumAbsoluteValue(arr)));
    }

    @DisplayName(
            "WHEN there is a negative number in the array, "
                    + "the absolute value of which is the largest among all values, "
                    + "THEN this element is returned.")
    @Test
    void testMaximumIsNegative() {
        int[] arr = {0, 5, -6};
        assertEquals(-6, Specs.maximumAbsoluteValue(arr));
    }

    @DisplayName(
            "WHEN there is a positive number in the array, "
                    + "the absolute value of which is the largest among all values, "
                    + "THEN this element is returned.")
    @Test
    void testMaximumIsPositive() {
        int[] arr = {0, 7, -6};
        assertEquals(7, Specs.maximumAbsoluteValue(arr));
    }

    @DisplayName(
            "WHEN there are only negative numbers in the array, "
                    + "THEN the number with the highest absolute value is returned.")
    @Test
    void testMaximumAllValueNegative() {
        int[] arr = {-6, -5, -4, -10, -9, -8, -7};
        assertEquals(-10, Specs.maximumAbsoluteValue(arr));
    }

    @DisplayName(
            "WHEN there are only positive numbers in the array, "
                    + "THEN the largest element is returned.")
    @Test
    void testMaximumAllValuePositive() {
        int[] arr = {6, 5, 4, 10, 9, 8, 7};
        assertEquals(10, Specs.maximumAbsoluteValue(arr));
    }

    @DisplayName("WHEN an array of length one is passed into `maximumAbsoluteValue()`, "
            + "THEN the only element in that array is returned.")
    @Test
    void testArrayOneElement() {
        int[] testFirst = new int[]{1};
        int[] testTwo = new int[]{-1};

        assertEquals(testFirst[0], Specs.maximumAbsoluteValue(testFirst));
        assertEquals(testTwo[0], Specs.maximumAbsoluteValue(testTwo));
    }

    @DisplayName("WHEN we call `uppercaseAt()` with a String with an uppercase "
            + "character at position i, THEN it should return true.")
    @Test
    void testUppercaseAt() {
        assertTrue(Specs.uppercaseAt("Hello", 0));
    }

    @DisplayName("WHEN we call `uppercaseAT()` with the string 'CHEESE yay' and i = 6"
            + "THEN it should return false.")
    @Test
    void testCheeseyay() {
        boolean output = Specs.uppercaseAt("CHEESE yay", 6);
        assertFalse(output);
    }

    @DisplayName("WHEN we call `uppercaseAt()` with a String with an uppercase "
            + "character at position i, THEN it should return true.")
    @Test
    void testUppercaseAtTrue() {
        assertTrue(Specs.uppercaseAt("Hello", 0));
        assertTrue(Specs.uppercaseAt("APPLE", 1));
        assertTrue(Specs.uppercaseAt("APPLE", 4));
        assertTrue(Specs.uppercaseAt("baNana", 2));
        assertTrue(Specs.uppercaseAt("1d5nal#fRa3", 8));
    }

    @DisplayName("WHEN we call `uppercaseAt()` with a String with a non-uppercase "
            + "character at position i, THEN it should return false.")
    @Test
    void testUppercaseAtFalse() {
        assertFalse(Specs.uppercaseAt("Hello", 1));
        assertFalse(Specs.uppercaseAt("apple", 0));
        assertFalse(Specs.uppercaseAt("L8R", 1));
        assertFalse(Specs.uppercaseAt("mWe75^H", 5));
    }

    @DisplayName("WHEN we call `zeroThrough()` and the first entry of the array is "
            + "the key, THEN it should return 0.")
    @Test
    void testZeroThroughFirstReturned() {
        assertEquals(0, Specs.zeroThrough(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @DisplayName("WHEN we call `zeroThrough()` and the last entry of the array is "
            + "the key, THEN it should return the last index.")
    @Test
    void testZeroThroughLastReturned() {
        assertEquals(4, Specs.zeroThrough(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @DisplayName("WHEN we call `zeroThrough()` and the key is not present in the "
            + "array, THEN the array length should be returned.")
    @Test
    void testZeroThroughUnfoundReturn() {
        assertEquals(5, Specs.zeroThrough(new int[]{1, 2, 3, 4, 5}, 6));
    }

    @DisplayName("WHEN we call `zeroThrough()` and the key is present multiple "
            + "times, THEN the first index should be returned.")
    @Test
    void testZeroThroughMultipleKey() {
        assertEquals(1, Specs.zeroThrough(new int[]{1, 2, 3, 2, 1}, 2));
    }

    @DisplayName("WHEN we call `zeroThrough()` and the key appears once "
            + ", THEN the key entries and all entries to its left are "
            + "zeroed out, and no entries to its right are zeroed out.")
    @Test
    void testZeroThroughZeroesCorrectly() {
        int[] nums = {1, 2, 3, 4, 5}; // save reference in local variable for later
        int loc = Specs.zeroThrough(nums, 3);
        for (int i = 0; i <= loc; i++) {
            assertEquals(0, nums[i]);
        }
        for (int j = loc + 1; j < nums.length; j++) {
            assertNotEquals(0, nums[j]);
        }
    }

    @DisplayName("WHEN we call `zeroThrough()` and the key does not appear "
            + "in the array, THEN the entire array is zeroed out.")
    @Test
    void testZeroThroughZeroesAll() {
        int[] nums = {1, 2, 3, 4, 5}; // save reference in local variable for later
        Specs.zeroThrough(nums, 6); // don't need to store return value
        for (int i = 0; i < nums.length; i++) {
            assertEquals(0, nums[i]);
        }
    }

}
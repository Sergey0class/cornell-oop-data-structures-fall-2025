package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrequencyOfTest {

    @DisplayName("WHEN an array contains a given `key` value exactly once, THEN `frequencyOf()` "
            + "returns 1 regardless of the position of the key.")
    @Test
    void testPresentOnce() {
        assertEquals(1, Invariants.frequencyOf(0, new int[] { 0, 1, 2, 3, 4 }), "First element");
        assertEquals(1, Invariants.frequencyOf(2, new int[] { 0, 1, 2, 3, 4 }), "Middle element");
        assertEquals(1, Invariants.frequencyOf(4, new int[] { 0, 1, 2, 3, 4 }), "Last element");
    }

    @DisplayName("WHEN a non-empty array does not contain a given `key` value exactly once, THEN "
            + "`frequencyOf()` returns 0.")
    @Test
    void testAbsentNonempty() {
        assertEquals(0, Invariants.frequencyOf(5, new int[] { 0, 1, 2, 3, 4 }));
    }

    @DisplayName("WHEN we call `frequencyOf()` passing in an empty array, THEN it returns 0.")
    @Test
    void testAbsentEmpty() {
        assertEquals(0, Invariants.frequencyOf(5, new int[0]));
    }

    @DisplayName("WHEN an array contains a given `key` value multiple times, THEN `frequencyOf()` "
            + "returns the frequency of this element.")
    @Test
    void testPresentMultiple() {
        assertEquals(5, Invariants.frequencyOf(1, new int[] { 1, 1, 1, 1, 1 }), "Filled with key");
        assertEquals(2, Invariants.frequencyOf(1, new int[] { 1, 0, 0, 0, 1 }), "Just at ends");
        assertEquals(3, Invariants.frequencyOf(1, new int[] { 0, 1, 1, 1, 0 }), "Just in middle");
    }

    @DisplayName("WHEN the array contains the given negative `key` value more than once, THEN `frequencyOf()`"
            + "returns the frequency of this element.")
    @Test
    void testPresentNegativeKey() {
        assertEquals(1, Invariants.frequencyOf(-1, new int[] { 1, 1, -1, 1, 1 }));
        assertEquals(2, Invariants.frequencyOf(-2, new int[] { 0, 0, -2, 0, -2 }));
        assertEquals(3, Invariants.frequencyOf(-3, new int[] { -3, 1, -3, 1, -3 }));
    }

}

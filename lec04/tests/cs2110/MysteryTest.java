package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MysteryTest {

    @DisplayName("When the array has an element > 0, then its index is returned.")
    @Test
    void testPositiveIndex() {
        assertEquals(6, Invariants.mystery(new int[] { 0, 0, 0, 0, 0, 0, 1 }));
        assertEquals(3, Invariants.mystery(new int[] { 0, 0, 0, 1, 0, 0, 0 }));
    }

    @DisplayName("When the array has multiple elements > 0, the index of the first such number is returned.")
    @Test
    void testPositiveMultipleNumbers() {
        assertEquals(1, Invariants.mystery(new int[] { 0, 1, 0, 0, 0, 0, 1 }));
        assertEquals(2, Invariants.mystery(new int[] { 0, 0, 1, 1, 0, 1, 0 }));
    }

    @DisplayName("When there are no positive numbers in the array or only 0, -1 is returned")
    @Test
    void testNotPositiveIndex() {
        assertEquals(-1, Invariants.mystery(new int[] { 0, 0, 0, 0, 0, 0, 0 }));
        assertEquals(-1, Invariants.mystery(new int[] { -2, 0, 0, -1, 0, -1, 0 }));
    }

    @DisplayName("When there is no number in the array, the number -1 is returned")
    @Test
    void testEmptyArray() {
        assertEquals(-1, Invariants.mystery(new int[] {}));
    }

    @DisplayName("When an array has the first positive number at the first index, then the array returns that index")
    @Test
    void testFirstPositiveIndex() {
        assertEquals(0, Invariants.mystery(new int[] { 1, 2, 3, 4 }));
    }

    @DisplayName("When there is one positive number in the array, then its index is returned")
    @Test
    void testOneNumber() {
        assertEquals(0, Invariants.mystery(new int[] { 1 }));
    }

    @DisplayName("When there is one negative number in the array, then -1 is returned")
    @Test
    void testOnlyZero() {
        assertEquals(-1, Invariants.mystery(new int[] { 0 }));
    }
}

package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArgminTest {

    @DisplayName("WHEN an array contains one element, THEN this element (at index 0) is its argmin.")
    @Test
    void testOneElement() {
        assertEquals(0, Invariants.argmin(new double[] { 5 }));
    }

    @DisplayName("WHEN an array contains two distinct elements, THEN the index of the smaller"
            + "element is returned by `argmin()`.")
    @Test
    void testTwoElements() {
        assertEquals(0, Invariants.argmin(new double[] { 2, 3 }), "First element smaller");
        assertEquals(1, Invariants.argmin(new double[] { 3, 2 }), "Second element smaller");
    }

    @DisplayName("WHEN an array with at least 3 elements has a unique minimum element, THEN"
            + "the index of this minimum is returned by `argmin()`.")
    @Test
    void testLongArrayOneMinimum() {
        assertEquals(0, Invariants.argmin(new double[] { 0, 1, 2, 3, 4 }), "Minimum at beginning");
        assertEquals(2, Invariants.argmin(new double[] { 1, 2, 0, 3, 4 }), "Minimum in middle");
        assertEquals(4, Invariants.argmin(new double[] { 4, 3, 2, 1, 0 }), "Minimum at end");
    }

    @DisplayName("WHEN all elements of an array are the same, "
            + "THEN either the index of the last element or the first is returned")
    @Test
    void testIdenticalElements() {
        double[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
        int i = Invariants.argmin(nums);
        for (int j = 0; j < nums.length; j++) {
            assertTrue(nums[j] >= nums[i], "Index of first minimum or last");
        }
    }

    @DisplayName("WHEN an array has the same number of negative minimum elements, "
            + "THEN the index of such element is returned")
    @Test
    void testNegativeElements() {
        double[] nums = { 1, 1, 1, -1, 1, 1, -1, 1 };
        int i = Invariants.argmin(nums);
        for (int j = 0; j < nums.length; j++) {
            assertTrue(nums[j] >= nums[i], "Index of first minimum or last");
        }
    }

    @DisplayName("WHEN an array contains multiple minima, THEN `argmin()` returns the index of "
            + "one of them.")
    @Test
    void testMultipleMinima() {
        double[] nums = { 1, 2, 0, 3, 4, 0, 5, 6 };
        int i = Invariants.argmin(nums);
        for (int j = 0; j < nums.length; j++) {
            assertTrue(nums[j] >= nums[i], "Index of first minimum or last");
        }
    }
}

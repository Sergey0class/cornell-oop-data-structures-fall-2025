package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParitySplitTest {

    /**
     * Helper method to check whether an array contains the same elements as another array.
     */
    void assertSameElementsAs(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length, "Arrays have different lengths");

        // build list of expected numbers
        List<Integer> expectedList = new ArrayList<>();
        for (int i=0; i<expected.length; i++) {
            expectedList.add(expected[i]);
        }

        // scan over actual numbers, checking for presence in expected list, then removing
        for (int j=0; j<actual.length; j++) {
            assertTrue(expectedList.contains(actual[j]), "Missing element: " + actual[j]);
            expectedList.remove((Integer) actual[j]);
        }
    }

    /**
     * Helper method to check whether an array has been parity split with a correctly reported split
     * point.
     */
    void assertParitySplit(int[] nums, int splitPoint) {
        // check that all numbers to the left of index `splitPoint` are even
        for (int i = 0; i < splitPoint; i++) {
            assertEquals(0, nums[i] % 2);
        }

        // check that all numbers to the right of and including index `splitPoint` are odd
        for (int i = splitPoint; i < nums.length; i++) {
            assertEquals(1, nums[i] % 2);
        }
    }

    @DisplayName("WHEN an array is already parity split, THEN calling `paritySplit()` preserves the "
            + "split and returns the correct split point.")
    @Test
    public void testAlreadySplit() {
        int[] nums = {0,2,4,1,3,5};
        int[] numsOriginal = Arrays.copyOf(nums, nums.length);
        int i = Invariants.paritySplit(nums);
        assertSameElementsAs(numsOriginal, nums);
        assertParitySplit(nums,i);
    }

    @DisplayName("WHEN an array is parity split with odds first, THEN calling `paritySplit()` moves"
            + "the evens to the left and returns the correct split point.")
    @Test
    public void testSplitWrongWay() {
        int[] nums = {1,3,5,7,0,2,4};
        int[] numsOriginal = Arrays.copyOf(nums, nums.length);
        int i = Invariants.paritySplit(nums);
        assertSameElementsAs(numsOriginal, nums);
        assertParitySplit(nums,i);
    }

    @DisplayName("WHEN an array of only even `int`s is parity split, THEN calling `paritySplit()` "
            + "returns the length of the array.")
    @Test
    public void testOnlyEven() {
        int[] nums = {0,0,2,2,4,4,6,6};
        int[] numsOriginal = Arrays.copyOf(nums, nums.length);
        int i = Invariants.paritySplit(nums);
        assertSameElementsAs(numsOriginal, nums);
        assertEquals(8,i);
    }

    @DisplayName("WHEN an array of only odd `int`s is parity split, THEN calling `paritySplit()` "
            + "returns 0.")
    @Test
    public void testOnlyOdd() {
        int[] nums = {1,1,1,3,3,5};
        int[] numsOriginal = Arrays.copyOf(nums, nums.length);
        int i = Invariants.paritySplit(nums);
        assertSameElementsAs(numsOriginal, nums);
        assertEquals(0,i);
    }

    @DisplayName("WHEN an array contains a mix of odd and even numbers, THEN it is correctly "
            + "parity split.")
    @Test
    public void testMixedParity() {
        int[] nums = {0,2,3,5,1,7,4,6,2,3,7,5,1,6,4,0};
        int[] numsOriginal = Arrays.copyOf(nums, nums.length);
        int i = Invariants.paritySplit(nums);
        assertSameElementsAs(numsOriginal, nums);
        assertParitySplit(nums,i);
    }
}

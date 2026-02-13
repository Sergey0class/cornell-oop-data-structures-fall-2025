package cs2110;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeTest {

    @DisplayName("WHEN both arrays are empty, THEN an empty array is returned")
    @Test
    void mergeTestLengthZeroAB() {

        int[] A = new int[]{};
        int[] B = new int[]{};

        assertArrayEquals(new int[]{}, Invariants.merge(A, B));
    }

    @DisplayName("WHEN array 'A' is empty, THEN array 'B' is returned")
    @Test
    void mergeTestLengthZeroA() {

        int[] A = new int[]{};
        int[] B = new int[]{1, 2, 3};

        assertArrayEquals(B, Invariants.merge(A, B));

    }

    @DisplayName("WHEN array 'B' is empty, THEN array 'A' is returned")
    @Test
    void mergeTestLengthZeroB() {

        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{};

        assertArrayEquals(A, Invariants.merge(A, B));

    }

    @DisplayName("WHEN arrays 'A' and 'B' contain no more than one value, "
            + "THEN a merged array sorted in ascending order is returned")
    @Test
    void mergeTestLengthOneAB() {

        int[] A = new int[]{1};
        int[] B = new int[]{2};

        assertArrayEquals(new int[]{1, 2}, Invariants.merge(A, B));

    }

    @DisplayName("WHEN two arrays are joined, THEN a merged ascending sorted array is returned")
    @Test
    void mergeTestMerge() {

        int[] A = new int[]{1, 3, 5, 7, 9};
        int[] B = new int[]{2, 4, 6, 8, 10};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Invariants.merge(A, B));

    }

    @DisplayName("WHEN array 'A' has values that > all values in array 'B', "
            + "THEN the correctly sorted merged array is returned")
    @Test
    void mergeTestMergeValueBiggerA() {

        int[] A = new int[]{4, 5, 6};
        int[] B = new int[]{1, 2, 3};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, Invariants.merge(A, B));

    }

    @DisplayName("WHEN array 'B' has values that > all values in array 'A', "
            + "THEN the correctly sorted merged array is returned")
    @Test
    void mergeTestMergeValueBiggerB() {

        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{4, 5, 6};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, Invariants.merge(A, B));

    }

    @DisplayName("When in arrays 'A' and 'B' all values are the same, "
            + "then an array that has all values from 'A' and 'B' is returned")
    @Test
    void mergeTestMergeValueEqualsAB() {

        int[] A = new int[]{1, 1, 1};
        int[] B = new int[]{1, 1, 1};

        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, Invariants.merge(A, B));

    }

    @DisplayName("WHEN two arrays with negative values inside are joined, "
            + "THEN the merged upward sorted array is returned")
    @Test
    void mergeTestMergeNegativeValue() {

        int[] A = new int[]{-9, -7, -5, -3, -1};
        int[] B = new int[]{-10, -8, -6, -4, -2};

        assertArrayEquals(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1}, Invariants.merge(A, B));

    }

    @DisplayName("When the last value of array 'A' is the same as the first value of 'B', "
            + "THEN the merged upward sorted array is returned")
    @Test
    void mergeTestMergeEqualsFirstAndLastValue() {

        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{3, 4, 5};

        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5}, Invariants.merge(A, B));

    }

    @DisplayName("WHEN two arrays are combined, "
            + "THEN the final length of the array is not > and not < the total combined length.")
    @Test
    void mergeTestMergeEqualLength() {

        int[] A = new int[]{1, 3, 5};
        int[] B = new int[]{2, 4, 6, 8, 10};

        assertEquals(8, Invariants.merge(A, B).length);

    }
}
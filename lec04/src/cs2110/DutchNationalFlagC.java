package cs2110;

public class DutchNationalFlagC {

    /**
     * Swaps the elements in `arr` at indices `x` and `y` in place.
     */
    static void swap(char[] arr, int x, int y) {
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    /**
     * Rearranges the elements of `arr` so that all 'r' elements appear before
     * all 'w' elements, which appear before all 'b' elements. Requires each
     * element of `arr` to be either 'r', 'w', or 'b'.
     */
    static void dutchNationalFlagAlgorithm(char[] arr) {

        int i = 0;
        int j = 0;
        int k = 0;

        /*
         * Loop invariant:
         * 1. red = colors from arr[0..i), [0..0) is an empty set.
         * 2. white = colors from arr[i..j), [0..0) is an empty set.
         * 3. blue = colors from [j..k), [0..0) is an empty set.
         * 4. unknown color = colors from [k..arr.length).
         * 5. 0 <= i <= j <= k <= arr.length.
         */
        while (k < arr.length) {

            if (arr[k] == 'w') {
                swap(arr, j, k);
                j++;
            } else if (arr[k] == 'r') {
                swap(arr, k, j);
                swap(arr, j, i);
                i++;
                j++;
            }

            k++;
        }
    }
}


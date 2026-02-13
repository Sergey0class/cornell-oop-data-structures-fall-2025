package cs2110;

public class DutchNationalFlagD {

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

        int i = arr.length;
        int j = arr.length;
        int k = arr.length;

        /*
         * Loop invariant:
         * 1. red = colors from arr[i..j), [arr.length..arr.length) is an empty set.
         * 2. white = colors from arr[j..k), [arr.length..arr.length) is an empty set.
         * 3. blue = colors from [k..arr.length), [arr.length..arr.length) is an empty set.
         * 4. unknown color = colors from [0..i).
         * 5. 0 <= i <= j <= k <= arr.length.
         */
        while (i > 0) {

            if (arr[i - 1] == 'w') {
                swap(arr, i - 1, j - 1);
                j--;
            } else if (arr[i - 1] == 'b') {
                swap(arr, i - 1, j - 1);
                swap(arr, j - 1, k - 1);
                j--;
                k--;
            }

            i--;
        }
    }
}

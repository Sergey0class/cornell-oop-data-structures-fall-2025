package cs2110;

public class DutchNationalFlagB {

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
        int j = arr.length;
        int k = arr.length;

        /*
         * Loop invariant:
         * 1. red = colors from arr[0..i), [0..0) is an empty set.
         * 2. white = colors from arr[j..k), [0..0) is an empty set.
         * 3. blue color = colors from arr[k..arr.length), [arr.length..arr.length) is an empty set.
         * 4. unknown color = colors from [i..j)
         * 5. 0 <= i <= j <= k <= arr.length.
         */
        while (i < j) {

            if (arr[i] == 'r') {
                i++;
            } else if (arr[i] == 'w') {
                swap(arr, i, j - 1);
                j--;
            } else {
                swap(arr, i, k - 1);
                if (j == k) {
                    j--;
                }
                k--;
            }
        }
    }
}

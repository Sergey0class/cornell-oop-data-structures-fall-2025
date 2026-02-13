package cs2110;

class DutchNationalFlagA {

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
        int k = arr.length;

        /*
         * Loop invariant:
         * 1. red color = colors from arr[0..i), [0..0) is an empty set.
         * 2. white color = colors from arr[i..j), [0..0) is an empty set.
         * 3. Blue Color = colors from arr[k..arr.length), [arr.length..arr.length) is an empty set.
         * 4. unknown color = colors from [j..k)
         * 5. 0 <= i <= j <= k <= arr.length.
         */
        while (j < k) {

            if (arr[j] == 'r') {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[j] == 'w') {
                j++;
            } else {
                swap(arr, j, k - 1);
                k--;
            }
        }
    }
}


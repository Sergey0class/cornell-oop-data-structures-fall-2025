package cs2110;

public class Specs {

    /**
     * Returns the character with the greatest number of occurrences in the given String `s`. If
     * there are multiple such characters, returns the one that appears first in `s`. Requires that
     * `s.length() > 0`.
     */
    public static char mostFrequent(String s) {

        int[] count = new int[65536];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        char max = s.charAt(0);
        int maxValue = count[s.charAt(0)];

        for (int i = 1; i < s.length(); i++) {

            char c = s.charAt(i);
            int newValue = count[c];

            if (maxValue < newValue) {
                maxValue = newValue;
                max = c;
            }
        }

        return max;
    }

    /**
     * Locates the first instance of the smallest entry of `a` and moves this to the first index,
     * rotating the other entries one index to the right to make space. For example, {2,3,4,1,5,6,1}
     * would become {1,2,3,4,5,6,1}. Returns the value of the smallest entry. Requires that
     * `a.length > 0`.
     */
    public static int selectSmallest(int[] a) {

        int minValue = a[0];
        int minValueIndex = 0;

        for (int i = 1; i < a.length; i++) {
            if (minValue > a[i]) {
                minValue = a[i];
                minValueIndex = i;
            }
        }

        if (minValueIndex == 0) {
            return minValue;
        }

        for (int i = minValueIndex; i > 0; i--) {

            a[i] = a[i - 1];

        }

        a[0] = minValue;
        return minValue;
    }

    /**
     * Shifts the entries of `a` to the left to fill in the spaces previously occupied by 0s. For
     * example, the array {1,0,2,0,0,3} would become {1,2,3,x,x,x} with any elements occupying its
     * last three indices. Returns the number of non-zero entries originally in `a`. Requires that
     * `a.length > 0`.
     */
    public static int condense(int[] a) {

        int k = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {

                if (i != k) {
                    a[k] = a[i];
                    a[i] = 0;
                }

                k++;
            }
        }
        return k;
    }

    /**
     * Returns the value "true" if all elements of the arrays "expected" and "actual" are equal up
     * to and including 'n' elements, otherwise returns the value "false". Requires that `a.length >
     * 0`.
     */
    public static boolean condenseTestHelper(int[] expected, int[] actual, int n) {

        for (int i = 0; i < n; i++) {
            if (expected[i] != actual[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the longest String `p` that is a prefix of both given Strings `s` and `t`. A String
     * `p` is a prefix of a String `s` if `p = s.substring(0,i)` for some `i`. For example,
     * `longestCommonPrefix("cactus", "cabbage") = "ca"`. Requires that `s.length() > 0` and
     * `t.length() > 0`.
     */
    public static String longestCommonPrefix(String s, String t) {

        int lengthMin = Math.min(s.length(), t.length());

        for (int i = 0; i < lengthMin; i++) {

            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }

        }
        return s.substring(0, lengthMin);
    }

    /**
     * Returns 1 if the value from the input array is not duplicated in the output array, otherwise
     * it returns the number of copies.
     */
    public static int validOutputDuplicate(int[] output, int value) {

        int count = 0;

        for (int j = 0; j < output.length; j++) {

            if (value == output[j]) {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns the arithmetic mean of all the numbers in the array. Requires that 'arr.length >=1'.
     */
    public static double mean(double[] arr) {
        double sum = 0;

        for (double v : arr) {
            sum += v;
        }
        return sum / arr.length;
    }

    /**
     * Returns the entry with the largest absolute value contained in array `arr`. Requires that
     * `arr.length >= 1` (i.e., `arr` is non-empty).
     */
    public static int maximumAbsoluteValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Returns the number of elements in the array whose value was below 0. The value of all such
     * elements is replaced by 0. If there were no such values in the array, the method returns 0.
     */
    public static int cleanData(double[] data) {
        int numCorrections = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                data[i] = 0;
                numCorrections++;
            }
        }
        return numCorrections;
    }

    /**
     * Each element of the array is replaced by the largest value among all the preceding elements.
     * As a result, the array is sorted in non-decreasing order.
     */
    public static void prefixMax(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                a[i] = a[i - 1];
            }
        }
    }

    /**
     * Returns a single digit from 0 to 9 if there is such a character in the string s. If there are
     * several numeric characters, the method returns the first one. Otherwise, the method returns
     * the value -1.
     */
    public static int firstNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                return c - '0';
            }
        }
        return -1;
    }

    /**
     * Returns the factorial of the number n. Requires that `n >=0`.
     */
    public static int factorial(int n) {
        return n < 2 ? 1 : n * factorial(n - 1);
    }

    /**
     * Returns `true` if the character in `str` at index `i` is uppercase, otherwise returns
     * `false`. Requires that `0 <= i < str.length()`.
     */
    public static boolean uppercaseAt(String str, int i) {
        return Character.isUpperCase(str.charAt(i));
    }

    /**
     * Zeroes-out all entries before and including the first instance of `key` in `arr` and returns
     * the `index` where `key` was found. If `key` is not present in `arr`, then all indices of
     * `arr` are zeroed-out, and `arr.length` is returned.
     */
    public static int zeroThrough(int[] arr, int key) {
        int i = 0;
        int val;
        while (i < arr.length) {
            val = arr[i];
            arr[i] = 0;
            if (val == key) {
                return i;
            }
            i++;
        }
        return i;
    }
}

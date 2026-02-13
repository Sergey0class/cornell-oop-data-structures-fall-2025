package cs2110;

public class Invariants {

    /**
     * Returns a sorted (in ascending order) array consisting of all of the entries
     * from both given arrays `a` and `b`. Requires that `a` and `b` are sorted
     * in ascending order.
     */
    static int[] merge(int[] a, int[] b) {

        int i = 0;
        int k = 0;

        int j = 0;

        int newLength = a.length + b.length;
        int[] mergeArray = new int[newLength];

        /*
         * Loop invariant:
         * 1. mergeArray[0..j) = contains all elements from a[0..i) and b[0..k).
         * 2. mergeArray[0..j) = contains elements <= all elements in a[i..a.length) and b[k..b.length).
         * 3. mergeArray[0..j) = sorted in ascending order.
         * 4. j = i + k.
         * 5. 0 <=i <= a.length.
         * 6. 0 <=k <= b.length.
         * 7. 0 <=j <= mergeArray.length.
         */
        while (j < newLength) {

            if (i == a.length) {
                mergeArray[j] = b[k];
                k++;
            } else if (k == b.length) {
                mergeArray[j] = a[i];
                i++;
            } else if (a[i] <= b[k]) {
                mergeArray[j] = a[i];
                i++;
            } else {
                mergeArray[j] = b[k];
                k++;
            }
            j++;
        }

        return mergeArray;

    }

    /**
     * Returns a new, "defragmented" copy of the given `words` array in which all
     * `null` entries have been removed and all remaining entries have retained
     * their same relative positions. For example, the input array {"apple", null,
     * "cherry", null, null, "fig", null} would result in the output array
     * {"apple", "cherry", "fig"}.
     */
    static String[] defragment(String[] words) {

        int i = 0;
        int k = 0;
        int j = 0;
        int count = 0;

        /*
         * Loop invariant:
         * 1. count = number of values that are != null in words[0..i).
         * 2. unknown = words[i..words.length).
         * 3. 0 <= i <= words.length.
         */
        while (i < words.length) {

            if (words[i] != null) {
                count++;
            }

            i++;
        }

        String[] defragmentArrayCopy = new String[count];

        /*
         * Loop invariant:
         * 1. defragmentArrayCopy[0..k) copied values from words[0..j).
         * 2. unknown = defragmentArrayCopy[k..count).
         * 3. 0 <= j <= words.length.
         * 4. 0 <= k <= count.
         */
        while (j < words.length) {

            if (words[j] != null) {
                defragmentArrayCopy[k] = words[j];
                k++;
            }

            j++;
        }

        return defragmentArrayCopy;

    }

    /**
     * Returns whether `a` contains duplicate entries, distinct indices
     * `i != j` with `a[i] == a[j]`.
     */
    static boolean hasDuplicates(int[] a) {

        int i = a.length - 1;

        /*
         * Loop invariant:
         * 1. a[i+1..a.length-1] does not contain any duplicates (relative to the whole array).
         * 2. unknown = a[0..i].
         * 3. -1 <= i <= a.length-1.
         */
        while (i >= 0) {

            int j = 0;

            /*
             * Loop invariant:
             * 1. a[i] is not in a[0..j-1].
             * 2. unknown = a[j..i).
             * 3. -1 < j <= i <= a.length-1.
             */
            while (j < i) {
                if (a[i] == a[j]) {
                    return true;
                }
                j++;
            }
            i--;
        }
        return false;
    }

    /**
     * Returns the number of indices `i` for which `a[..i) < a[i]`.
     * Requires that `a` is non-empty, and all entries of `a` are positive.
     */
    static int countSkyscrapers(int[] a) {

        int i = 1;
        int indexMax = 0;
        int count = 1;

        /*
         * Loop invariant:
         * 1. count = number of skyscrapers in a[0..i).
         * 2. indexMax = index of the maximum value in a[0..i).
         * 3. 0 < i <= a.length.
         */
        while (i < a.length) {

            if (a[i] > a[indexMax]) {
                indexMax = i;
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * Returns `true` if `nums` contains two *consecutive* entries with the same
     * value. Otherwise, returns `false`.
     * Requires that nums.length > 0.
     */
    static boolean hasConsecutiveDuplicates(int[] nums) {

        boolean flagDuplicates = false;
        int i = 0;

        /*
         * Loop invariant:
         * 1. flagDuplicates == there are adjacent duplicates in nums[0..i]
         * 2. 0 <= i <= nums.length -1
         */
        while (i < nums.length - 1 && !flagDuplicates) {

            if (nums[i] == nums[i + 1]) {

                flagDuplicates = true;

            }

            i++;

        }

        return flagDuplicates;
    }

    /**
     * Returns the range of elements in `nums` (i.e., its largest element
     * minus its smallest element).
     * Requires that nums.length > 0.
     */
    static int range(int[] nums) {

        int i = 1;
        int max = nums[0];
        int min = nums[0];

        /*
         * Loop invariant:
         * 1. max = maximum value from nums[0..i)
         * 2. min = minimum value from nums[0..i)
         * 3. 0 < i <= nums.length
         */
        while (i != nums.length) {

            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < min) {
                min = nums[i];
            }

            i++;
        }

        return max - min;
    }

    /**
     * Returns an *index* of the maximum element in `nums`.
     * Requires that `nums` contains at least one element.
     */
    static int argmax(int[] nums) {

        int i = 1;
        int index = 0;

        /*
         * Loop invariant: `index` = index of the maximum value among the elements
         * nums[0..i). 0 < i <= nums.length.
         */
        while (i != nums.length) {

            if (nums[i] > nums[index]) {
                index = i;
            }

            i++;
        }

        return index;
    }

    /**
     * Returns the maximum value of an element in `nums`.
     * Requires that `nums` contains at least one element.
     */
    static int max(int[] nums) {

        int i = 1;
        int max = nums[0];

        /*
         * Loop invariant: `max` = maximum value among elements nums[0..i).
         * 0 < i <= nums.length.
         */
        while (i != nums.length) {

            if (nums[i] > max) {
                max = nums[i];
            }

            i++;
        }

        return max;
    }

    /**
     * Returns the number of elements in `nums` that are greater than the
     * given `bound`.
     */
    static int countAbove(int[] nums, int bound) {

        int i = 0;
        int count = 0;

        /*
         * Loop invariant: `count` = number of elements > 'bound' in nums[0..i).
         * 0 <= i <= nums.length.
         */
        while (i != nums.length) {

            if (nums[i] > bound)
                count++;

            i++;
        }
        return count;
    }

    /**
     * Returns the sum of all *positive* entries in the given array of `nums`.
     */
    static double sumPositives(double[] nums) {

        int i = 0;
        double sum = 0;

        /*
         * Loop invariant: `sum` = contains the sum of positive array values nums
         * [0..i). If not found, it is 0.
         */
        while (i != nums.length) {

            if (nums[i] > 0) {

                sum += nums[i];

            }
            i++;
        }

        return sum;
    }

    /**
     * Returns the sum of all entries in the given array of `nums`.
     */
    static double sum(double[] nums) {

        int i = 0;
        double sum = 0;

        /*
         * Loop invariant: `sum` = contains the sum of the elements of the nums
         * array[0..i).
         */

        while (i != nums.length) {

            sum = sum + nums[i];

            i++;
        }
        return sum;
    }

    /**
     * Returns the index of the first positive number in the array.
     * If there is no positive number in the array, returns -1.
     */
    static int mystery(int[] a) {

        int firstPositiveNumberIndex = -1;
        int countIndex = 0;

        /*
         * Loop invariant: `firstPositiveNumberIndex` = index of the first positive
         * number in `a[..countIndex).
         * If not found, it is -1.
         */
        while (countIndex < a.length && firstPositiveNumberIndex == -1) {

            if (a[countIndex] > 0) {
                firstPositiveNumberIndex = countIndex;
            }
            countIndex++;
        }
        return firstPositiveNumberIndex;
    }

    /**
     * Returns the number of occurrences of `key` among the elements in array `a`.
     */
    static int frequencyOf(int key, int[] a) {

        int i = 0;
        int count = 0;

        /*
         * Loop invariant: `count` = number of occurrences of `key` in `a[..i)`
         */
        while (i < a.length) {
            if (a[i] == key) {
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * Returns the index of the minimum element in `a`.
     * If multiple minimum values are found, the index is returned last found.
     * Requires `a` to contain at least one element.
     */
    static int argmin(double[] a) {
        int i = 1;
        int loc = 0;
        /*
         * Loop invariant: a[loc] is the minimum of a[0..i) AND loc is the largest index
         * in this range
         * 0 <= loc < i <= a.length
         */
        while (i < a.length) {
            if (a[i] <= a[loc]) {
                loc = i;
            }
            i++;
        }
        return loc;
    }

    /**
     * Swaps the entries a[x] and a[y].
     * Requires that 0 <= x < a.length` and 0 <= y < a.length.
     */
    static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     * Rearranges the elements of `a` so that all even elements appear before all
     * odd elements.
     * Returns the index of the first odd element, or returns `a.length` if all
     * elements are even.
     */
    static int paritySplit(int[] a) {
        int i = -1;
        int j = a.length - 1;
        /*
         * Loop invariant:
         * 1. a[0..i] is even (if i == -1, the range is empty)
         * 2. a(j..a.length-1] is odd (if j == a.length-1, the range is empty)
         * 3. -1 <= i <= j <= a.length
         */
        while (i < j) {
            if (a[j] % 2 != 0) {
                j--;
            } else {
                swap(a, i + 1, j);
                i++;
            }
        }
        return j + 1;
    }
}

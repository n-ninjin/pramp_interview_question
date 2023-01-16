package questions.k_messed_array_sort;

import java.util.Arrays;
/*
K-Messed Array Sort

Given an array of integers arr where each element is at most k places away from its sorted position,
code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2,
an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
Analyze the time and space complexities of your solution.

Example:
input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Constraints:
[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ 100
[input] integer k
0 ≤ k ≤ 20
[output] array.integer
 */

class Solution {
    /* Insertion sort */
    static int[] sortKMessedArray(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = x;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;
        /* Expected output: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} */
        sortKMessedArray(arr, k);
        System.out.println(Arrays.toString(arr));
        // TC: O(N * K)
        // SC: O(1)
    }

}
package questions.pairs_with_specific_difference;

/*
Pairs with Specific Difference
Given an array arr of distinct integers and a nonnegative integer k, write a function
findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k.
If no such pairs exist, return an empty array.
Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

Examples:
input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
output: []

Constraints:
[time limit] 5000ms
[input] array.integer arr
0 ≤ arr.length ≤ 100
[input]integer k
k ≥ 0
[output] array.array.integer
 */

import java.io.*;
import java.util.*;

class Solution {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        // your code goes here
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        List<int[]> list = new ArrayList<>();
        // x - y= k  x = k + y  y = arr[i]
        for (int i = 0; i < arr.length; i++) {
            int x = k + arr[i];
            if (hs.contains(x)) {
                list.add(new int[]{x, arr[i]});
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, -2, 2, 1};
        int[][] res = findPairsWithGivenDifference(arr, 1);
        /**
         * Expected output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
         */
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }

        int[] arr2 = {0, -1, -2, 2, 1};
        int[][] res2 = findPairsWithGivenDifference(arr2, 17);
        /**
         * Expected output: []
         */
        for (int[] r : res2) {
            System.out.println(Arrays.toString(r));
        }

    /*
    TC: O(N)
    SC: O(N)
    */
    }
}
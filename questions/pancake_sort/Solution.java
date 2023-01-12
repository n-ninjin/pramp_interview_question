package questions.pancake_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Pancake Sort
Given an array of integers arr:

Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
Write a function pancakeSort(arr) that sorts and returns the input array.
You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.

Example:

input:  arr = [1, 5, 4, 3, 2]

output: [1, 2, 3, 4, 5]
// to clarify, this is pancakeSort's output
// Analyze the time and space complexities of your solution.
Note: it’s called pancake sort because it resembles sorting pancakes on a plate with a spatula,
where you can only use the spatula to flip some of the top pancakes in the plate. To read more about the problem,
see the Pancake Sorting Wikipedia page.

Constraints:

[time limit] 5000ms
[input] array.integer arr
[input] integer k
0 ≤ k
[output] array.integer

Solution:
1. Find max element position
2. flip until max element position
3. flip the whole array
4. find next max element position and do step 2 and 3 until last element.
 */
class Solution {

    static void flip(int[] arr, int k) {
        int l = 0, r = k - 1;
        while (l < r) {
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--;
        }
    }

    static int getMaxIdx(int[] arr, int k) {
        int maxVal = arr[0];
        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static int[] pancakeSort(int[] arr) {
        int maxIdx;
        for (int i = arr.length; i > 1; i--) {
            maxIdx = getMaxIdx(arr, i);
            flip(arr, maxIdx + 1);
            flip(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        pancakeSort(arr);
        System.out.println(Arrays.toString(arr));
        // TC: O(N^2)
        // SC: O(1)
    }

}
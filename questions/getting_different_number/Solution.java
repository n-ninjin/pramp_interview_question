package questions.getting_different_number;
/*
Getting a Different Number
Given an array arr of unique nonnegative integers, implement a function getDifferentNumber
that finds the smallest nonnegative integer that is NOT in the array.
Even if your programming language of choice doesn’t have that restriction (like Python),
assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance,
the operation MAX_INT + 1 would be undefined in our case.
Your algorithm should be efficient, both from a time and a space complexity perspectives.
Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time,
see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed.
Do so without trading off the time complexity.
Analyze the time and space complexities of your algorithm.

Example:
input:  arr = [0, 1, 2, 3]
output: 4
Constraints:
[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ MAX_INT
0 ≤ arr[i] ≤ MAX_INT for every i, 0 ≤ i < MAX_INT
[output] integer
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * approach 1 : HashSet
     * TC: O(N)
     * SC: O(N)
     * @param arr
     * @return
     */
    static int getDifferentNumber(int[] arr) {
        // your code goes here
        Set<Integer> set = new HashSet<>();
        for (int n : arr) set.add(n);
        for (int i = 0; i < arr.length + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }

    static int getDifferentNumber2(int[] arr) {
        // your code goes here
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) actualSum += num;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // approach 1 : HashSet
        // TC: O(N)
        // SC: O(N)
        // Expected output : 2
        System.out.println(getDifferentNumber(new int[] {0, 1, 3}));

        // approach 2 : expectedSum
        // TC: O(N)
        // SC: O(1)
        // Expected output : 0
        System.out.println(getDifferentNumber2(new int[] {1, 2, 3}));
    }
}
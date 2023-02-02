package questions.array_of_array_products;
/*
Array of Array Products
Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the
integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers
and returns an array of the products.

Solve without using division and analyze your solution’s time and space complexities.
Examples:
input:  arr = [8, 10, 2]
output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]
input:  arr = [2, 7, 3, 4]
output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]

Constraints:
[time limit] 5000ms
[input] array.integer arr
0 ≤ arr.length ≤ 20
[output] array.integer
 */

import java.io.*;
import java.util.*;

class Solution {

    static int[] arrayOfArrayProducts(int[] arr) {
        // your code goes here
        int n = arr.length;
        if (n == 0 ||n == 1 ) return new int[] {};
        // [8, 10, 2]  left to right
        // [1,  8, 80] right to left
        // [20, 2, 1]
        //  20 16 80

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = 1;
        arr2[n - 1] = 1;

        // left to right |
        for (int i = 1; i < n; i++) {
            arr1[i] = arr[i - 1] * arr1[i - 1];
        }

        // right to left |
        for (int i = n - 2; i >= 0; i--) {
            arr2[i] = arr[i + 1] * arr2[i + 1];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i] * arr2[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        /**/
        int[] arr1 = {8, 10, 2};
        /*Expected value : [20, 16, 80]*/
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr1)));
        /*Expected value : [84, 24, 56, 42]*/
        int[] arr2 = {2, 7, 3, 4};
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr2)));
    /*
     TC: O(n)
     SC: O(n)
    */
    }
}
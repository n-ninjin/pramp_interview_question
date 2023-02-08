package questions.move_zeros_to_end;

/*
Move Zeros To End
Given a static-sized array of integers arr, move all zeroes in the array to the end of the array.
You should preserve the relative order of items in the array.

We should implement a solution that is more efficient than a naive brute force.

Examples:
input:  arr = [1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0]
output: [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0]
Constraints:

[time limit] 5000ms
[input] array.integer arr
0 ≤ arr.length ≤ 20
[output] array.integer
 */

import java.io.*;
import java.util.*;

class Solution {

    static int[] moveZerosToEnd(int[] arr) {
        // your code goes here
        int n = arr.length;

//    int zeroCnt = 0;
//    for (int i = 0; i < n; i++) {
//      if (arr[i] != 0) {
//        arr[zeroCnt++] = arr[i];
//      }
//    }

//  for (int i = zeroCnt; i < n; i++) {
//     arr[i] = 0;
//  }
        int  j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0};
        System.out.println(Arrays.toString(moveZerosToEnd(arr)));
        //TC: O(N)
        //SC: O(1)
    }
}

package questions.matrix_spiral_copy;

/*
Matrix Spiral Copy
Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values
into a 1D array in a spiral order, clockwise. Your function then should return that array. Analyze the time and space
 complexities of your solution.

Example:
input:  inputMatrix  = [ [1,    2,   3,  4,    5],
                         [6,    7,   8,  9,   10],
                         [11,  12,  13,  14,  15],
                         [16,  17,  18,  19,  20] ]

output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
See the illustration below to understand better what a clockwise spiral order looks like.

Constraints:
[time limit] 5000ms
[input] array.array.integer inputMatrix
1 ≤ inputMatrix[0].length ≤ 100
1 ≤ inputMatrix.length ≤ 100
[output] array.integer
 */

import java.io.*;
import java.sql.Array;
import java.util.*;

class Solution {

    static int[] spiralCopy(int[][] inputMatrix) {
        // your code goes here
        int m = inputMatrix.length; // row
        int n = inputMatrix[0].length; // col
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        List<Integer> list = new ArrayList<>();
        while (list.size() < m * n) {
            // left to right
            for (int col = left; col <= right; col++) {
                list.add(inputMatrix[top][col]);
            }
            top++;
            // top to down
            for (int row = top; row <= bottom; row++) {
                list.add(inputMatrix[row][right]);
            }
            right--;

            // right to left
            if(top <= bottom) {
                for (int col = right; col >= left; col--) {
                    list.add(inputMatrix[bottom][col]);
                }
                bottom--;
            }

            // bottom to top
            if(left <= right)  {
                for (int row = bottom; row >= top; row--) {
                    list.add(inputMatrix[row][left]);
                }
                left++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};
        /* Expected output:  [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]*/
        int[] case1 = {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12};
        System.out.println(Arrays.toString(spiralCopy(arr)));
        System.out.println(Arrays.equals(spiralCopy(arr), case1));
        //TC: O(N) N = rows * cols
        //SC: O(N) N = rows * cols

        int[][] arr2 = {{1,2,3,4,5},{6,7,8,9,10}};
        /* Expected output:  [1,2,3,4,5,10,9,8,7,6]*/
        System.out.println(Arrays.toString(spiralCopy(arr2)));
        int[] case2 = {1,2,3,4,5,10,9,8,7,6};
        System.out.println(Arrays.equals(spiralCopy(arr2), case2));


        int[][] arr3 = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        /* Expected output:  [1,11,12,13,14,15,16,17,18,19,20,10,9,8,7,6,5,4,3,2]*/
        System.out.println(Arrays.toString(spiralCopy(arr2)));
        int[] case3 = {1,11,12,13,14,15,16,17,18,19,20,10,9,8,7,6,5,4,3,2};
        System.out.println(Arrays.equals(spiralCopy(arr3), case3));

    }

}

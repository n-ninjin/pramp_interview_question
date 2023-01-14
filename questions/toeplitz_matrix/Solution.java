package questions.toeplitz_matrix;

/*
Toeplitz Matrix
A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element.
Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix.
The matrix can be any dimensions, not necessarily square.

For example,

[[1,2,3,4],
 [5,1,2,3],
 [6,5,1,2]]
is a Toeplitz matrix, so we should return true, while

[[1,2,3,4],
 [5,1,9,3],
 [6,5,1,2]]
isn’t a Toeplitz matrix, so we should return false.
 */
class Solution {
    static boolean isToeplitz(int[][] arr) {
        // Every element belongs to some diagonal, and it's prev element is it's top-left neighbor
        // r,c, we need to check arr[r][c] == arr[r + 1][c + 1] || r == 0 OR c == 0 OR arr[r - 1][c - 1] == arr[r][c]
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] != arr[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        /* Expected output: true */
        System.out.println(isToeplitz(arr1));
        int[][] arr2 = {{1, 2, 3, 4}, {5, 1, 9, 3}, {6, 5, 1, 2}};
        /* Expected output: false */
        System.out.println(isToeplitz(arr2));
        //TC: O(R * C)
        //SC: O(1)
    }
}

package questions.shifted_array_search;

/*
Shifted Array Search
A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and
you don’t have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5
becomes 3, 4, 5, 1, 2, after shifting it twice to the left.

Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns
the index of num in shiftArr. If num isn’t in shiftArr, return -1.
Assume that the offset can be any value between 0 and arr.length - 1.

input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
                                                 # outcome of shifting
                                                 # [2, 4, 5, 9, 12, 17]
                                                 # three times to the left

output: 3 # since it’s the index of 2 in arr
 */

import java.util.Arrays;

class Solution {

    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here
        int l = 0, r = shiftArr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (shiftArr[m] == num) {
                return m;
            } else if (shiftArr[m] >= shiftArr[l]) {
                if (num >= shiftArr[l] && num < shiftArr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (num <= shiftArr[r] && num > shiftArr[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 12, 17, 2, 4, 5};
        /* Expected output: [2, 4, 5, 9, 12, 17] */
        System.out.println(shiftedArrSearch(arr, 2));
        // TC: O(logN)
        // SC: O(1)
    }
/*
Pseudocode & Explanation
target = 2
0   1   2  3  4  5
                 r
9, 12, 17, 2, 4, 5
l
       m

1. m element is larger than first element in the array, the sub array l to m is non-shifted
  0   1   2  3  4  5
                   r
  9, 12, 17, 2, 4, 5
  l
         m

  if target is located in the non-shifted sub array go left
     r = m - 1;
  Otherwise go right
     l = m + 1;

  0   1   2  3  4  5
                   r
  9, 12, 17, 2, 4, 5
             l
                m

  0   1   2  3  4  5
                r
  9, 12, 17, 2, 4, 5 ==> answer = 3
             l
             m

2. m element is smaller than first element in the array, the sub array m to r is non-shifted
  if target is located in the non - rotated subarray go right
    l = m + 1;
  otherwise go left
    r = m - l;

*/

}
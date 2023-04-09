package questions.smallest_substring_of_all_characters;

import java.io.*;
import java.util.*;

/*
Smallest Substring of All Characters
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring
that finds the smallest substring of str containing all the characters in arr. Return "" (empty string)
if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.
Example:
input:  arr = ['x','y','z'], str = "xyyzyzyx"
output: "zyx"
Constraints:
[time limit] 5000ms
[input] array.character arr
1 ≤ arr.length ≤ 30
[input] string str
1 ≤ str.length ≤ 500
[output] string

 */
class Solution {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        // 65 - 122
        int[] charsT = new int[60];
        int[] charsS = new int[60];
        for (int i = 0; i < arr.length; i++) {
            charsT[arr[i] - 65]++;
        }

        int left = 0, min = Integer.MAX_VALUE, l = 0, r = -1;

        for (int right = 0; right < str.length(); right++) {
            char curRight = str.charAt(right);
            charsS[curRight - 65]++;

            while (include(charsT, charsS)) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    l = left;
                    r = right;
                }
                charsS[str.charAt(left) - 65]--;
                left++;
            }
        }
        return str.substring(l, r + 1);
    }

    public static boolean include(int[] tArr, int[] sArr) {
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] > sArr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] arr01 = {'x', 'y', 'z'};
        String str01 = "xyyzyzyx";
        // Case 1:
        // Expected value : zyx
        System.out.println(getShortestUniqueSubstring(arr01, str01));

        char[] arr02 = {'A', 'B', 'C'};
        String str02 = "ADOBECODEBANCDDD";
        // Case 2:
        // Expected value : BANC
        System.out.println(getShortestUniqueSubstring(arr02, str02));

        char[] arr03 = {'A', 'B', 'C', 'E', 'K', 'I'};
        String str03 = "KADOBECODEBANCDDDEI";
        // Case 3:
        // Expected value : KADOBECODEBANCDDDEI
        System.out.println(getShortestUniqueSubstring(arr03, str03));

        // TC: O(M + N)
        // SC: O(M + N)
    }

}

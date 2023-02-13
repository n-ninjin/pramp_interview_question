package questions.deletion_distance;

/*
Deletion Distance
The deletion distance of two strings is the minimum number of characters you need to delete in the two
strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:

By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.
Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance
between them. Explain how your function works, and analyze its time and space complexities.

Examples:
input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0

Constraints:
[input] string str1
[input] string str2
[output] integer
 */
import java.io.*;
import java.util.*;

class Solution {
    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
    static int deletionDistance(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }

    public static void main(String[] args) {
        // Expected output : 3
        System.out.println(deletionDistance("dog", "frog"));
        // Expected output : 0
        System.out.println(deletionDistance("some", "some"));
        // Expected output : 9
        System.out.println(deletionDistance("some", "thing"));
        // Expected output : 0
        System.out.println(deletionDistance("", ""));
        // SC: O(Max(m,n))
        // TC: O(2^Max(m,n))
    }

}

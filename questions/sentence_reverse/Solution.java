package questions.sentence_reverse;

/*
Sentence Reverse
You are given an array of characters arr that consists of sequences of characters separated by space characters.
Each space-delimited sequence of characters defines a word.
Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.
Explain your solution and analyze its time and space complexities.

Constraints:
    [time limit] 5000ms
    [input] array.character arr
    0 ≤ arr.length ≤ 100
    [output] array.character
 */

import java.util.Arrays;

class Solution {

    static char[] reverseWords(char[] arr) {
        // your code goes here
        int start = 0;
        // reverse all characters
        reverseArr(arr, start, arr.length - 1);
        // reverse each words
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverseArr(arr, start, i - 1);
                start = i + 1;
            }
            if (arr.length - 1 == i) {
                reverseArr(arr, start, i);
            }
        }
        return arr;
    }

    static void reverseArr(char[] arr, int l, int r) {
        while (l <= r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
    /* Expected output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ',
                          'm', 'a', 'k', 'e', 's', ' ',
                          'p', 'e', 'r', 'f', 'e', 'c', 't' ] */
        System.out.println(Arrays.toString(reverseWords(arr)));
        // TC: O(n)
        // SC: O(1)
    }

}
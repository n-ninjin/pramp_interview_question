package questions.decode_variations;

/*
Decode Variations
A letter can be encoded to a number in the following way:

'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
A message is a string of uppercase letters, and it is encoded first using this scheme.
For example, 'AZB' -> '1262'

Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.

Examples:
input:  S = '1262'
output: 3
explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.

Constraints:
[time limit] 5000ms
[input] string S
1 ≤ S.length ≤ 12
[output] integer

 */
class Solution {

    static int decodeVariations(String S) {
        // your code goes here
        return helper(S, 0);
    }

    static int helper(String s, int idx) {
        if (idx == s.length()) return 1;
        int cnt = 0;
        // 1 - 9
        cnt += helper(s, idx + 1);

        // 10 - 26
        if (idx + 1 < s.length()) {
            String val = "";
            val += s.charAt(idx);
            val += s.charAt(idx + 1);
            int num = Integer.valueOf(val);
            if (num > 0 && num < 27) {
                cnt += helper(s, idx + 2);
            }
        }

        return cnt;

        /*
             input: 1 262
               A  Tree(A)
             /   \
            B     Z
           / \    / \
          F   -   B  x
         /       AZB
        B
       ABFB

       input: Tree(L)
        12 6 2
         L
        / \
       F   x
      /
     B
     LFB
     output: 3
         * */

    }

    public static void main(String[] args) {
        /* Expected output : 3 */
        System.out.println(decodeVariations("1262"));

        /* Expected output : 2 */
        System.out.println(decodeVariations("83778549129"));

        /* Expected output : 120 */
        System.out.println(decodeVariations("122231131122"));

        // TC:
        // SC:
    }

}
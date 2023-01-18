package questions.decrypt_message;

/*
Decrypt Message

An infamous gang of cyber criminals named “The Gray Cyber Mob”, which is behind many hacking attacks and drug trafficking,
has recently become a target for the FBI. After intercepting some of their messages, which looked like complete nonsense,
the agency learned that they indeed encrypt their messages, and studied their method of encryption.
Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the last one,
add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII.
Convert the values back to letters.

For instance, to encrypt the word “crime”

Decrypted message:	c	r	i	m	e
Step 1:	99	114	105	109	101
Step 2:	100	214	319	428	529
Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q

The FBI needs an efficient method to decrypt messages. Write a function named decrypt(word) that receives a string that consists of
small latin letters only, and returns the decrypted word.
Explain your solution and analyze its time and space complexities.

Examples:

input:  word = "dnotq"
output: "crime"

input:  word = "flgxswdliefy"
output: "encyclopedia"

Constraints:
[time limit] 5000ms
[input] string word
The ASCII value of every char is in the range of lowercase letters a-z.
[output] string
 */
class Solution {

    static String decrypt(String word) {
        String s = "";
        int prev = 1, newValue = -1;
        int a = (int) 'a';

        for (int i = 0; i < word.length(); i++) {   // 100 110 111 116 113 => dnotq
            newValue = (int) word.charAt(i) - prev; // 100 - 1, 110 - 100, 111 - 110, 116 - 111
            prev = (int) word.charAt(i); // 100 110 111 116
            while (newValue < a) { // 99 // 10 + 26 * 4 = 114  // 1 + 26 * 4 = 105 // 5 + 104
                newValue += 26;
            }
            s = s + (char) newValue;// 99 114 105 109 => crime
        }

        return s;
    }

    public static void main(String[] args) {
        String word = "dnotq";
        /* Expected output: "crime" */
        System.out.println(decrypt(word));

        word = "flgxswdliefy";
        /* Expected output: "encyclopedia" */
        System.out.println(decrypt(word));
    }

}

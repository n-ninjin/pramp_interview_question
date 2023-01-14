package questions.root_of_number;

import java.util.Arrays;

/*
Root of Number
Many times, we need to re-implement basic functions without using any standard library functions already implemented.
For example, when designing a chip that requires very little memory space.

In this question we’ll implement a function root that calculates the n’th root of a number.
The function takes a non-negative number x and a positive integer n, and returns the positive n’th root of x within an error of 0.001
(i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).

Don’t be intimidated by the question. While there are many algorithms to calculate roots that require prior
knowledge in numerical analysis (some of them are mentioned here), there is also an elementary method which doesn’t
require more than guessing-and-checking. Try to think more in terms of the latter.
Make sure your algorithm is efficient, and analyze its time and space complexities.

Examples:
input:  x = 7, n = 3
output: 1.913

input:  x = 9, n = 2
output: 3

Constraints:
[time limit] 5000ms
[input] float x
0 ≤ x
[input] integer n
0 < n
[output] float
 */
class Solution {

    static double root(double x, int n) {
        double l = 0.0, r = x;
        double m = l + (r - l) / 2.0;
        while (r - l >= 0.001) {
            if (Math.pow(m, n) > x) {
                r = m;
            } else if (Math.pow(m, n) < x) {
                l = m;
            } else {
                break;
            }
            m = l + (r - l) / 2.0;
        }
        return m;
    }

    public static void main(String[] args) {
        /* Expected output 1.913 */
        System.out.println(root(7, 3));
        /* Expected output 3 */
        System.out.println(root(9, 2));
    }
    // power function takes a constant time O(1)
    // TC: O(log(N))
    // SP: O(1)
}
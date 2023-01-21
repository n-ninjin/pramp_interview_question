package questions.array_index_element_equality;

/*
Array Index & Element Equality
Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the
lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of
your solution and explain its correctness.

Examples:
input: arr = [-8,0,2,5]
output: 2 # since arr[2] == 2
input: arr = [-1,0,3,6]
output: -1 # since no index in arr satisfies arr[i] == i.

Constraints:
[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ 100
[output] integer

 */
class Solution {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < m) {
                l = m + 1;
            } else if (arr[m] == m && (m == 0 || arr[m - 1] < m - 1)) { // lowest index
                return m;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {-8, 0, 2, 5};
        int[] arr2 = {0, 1, 2, 3};
        /* expected output: 2 */
        System.out.println(indexEqualsValueSearch(arr1));
        /* expected output: 0 */
        System.out.println(indexEqualsValueSearch(arr2));
        // TC: O(logN)
        // SC: O(1)
    }

}
package questions.award_budget_cuts;

import java.util.Arrays;

/*
Award Budget Cuts
The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation
problem they’re facing. Originally, the committee planned to give N research grants this year. However, due to spending
cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a
decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every
grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously,
won’t be impacted.

Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that
finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget
constraint is met (i.e. sum of the N reallocated grants equals to newBudget).

Analyze the time and space complexities of your solution.
Example:
input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
output: 47 # and given this cap the new grants array would be
           # [2, 47, 47, 47, 47]. Notice that the sum of the
           # new grants is indeed 190

Constraints:
[time limit] 5000ms
[input] array.double grantsArray
0 ≤ grantsArray.length ≤ 20
0 ≤ grantsArray[i]
[input] double newBudget
[output] double
 */
class Solution {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // Sort the grants array in ascending order
        Arrays.sort(grantsArray);
        int sum = 0;
        for (int i = 0; i < grantsArray.length; i++) {
            // Check if the current grant, along with the remaining grants, would exceed the new budget
            if (sum + (grantsArray.length - i) * grantsArray[i] <= newBudget) {
                // If not, add the current grant to the sum
                sum += grantsArray[i];
            } else {
                // If so, calculate the cap by dividing the remaining budget by the number of remaining grants
                return (newBudget - sum) / (grantsArray.length - i);
            }
        }
        // If the loop completes, return the last grant in the array
        return grantsArray[grantsArray.length - 1];
    }

    public static void main(String[] args) {
        /* Expected output : 47.0 */
        double[] arr1 = {2, 100, 50, 120, 1000};
        System.out.println(findGrantsCap(arr1, 190));

        /* Expected output : 23.8 */
        double[] arr2 = {21,100,50,120,130,110};
        System.out.println(findGrantsCap(arr2, 140));

        // TC: O(NlogN)
        // SC: O(1)
    }

}
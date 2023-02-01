package questions.time_planner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Time Planner
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration
dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot
that satisfies the duration requirement, return an empty array.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have
elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two.
The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot.
The input variable dur is a positive integer that represents the duration of a meeting in seconds.
The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a
person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.
Implement an efficient solution and analyze its time and space complexities.

Examples:
input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 8
output: [60, 68]

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 12
output: [] # since there is no common slot whose duration is 12

Constraints:
[time limit] 5000ms
[input] array.array.integer slotsA
1 ≤ slotsA.length ≤ 100
slotsA[i].length = 2
[input] array.array.integer slotsB

1 ≤ slotsB.length ≤ 100
slotsB[i].length = 2
[input] integer
[output] array.integer

 */

class Solution {

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        // your code goes here
        int i = 0, j = 0;
        while (i < slotsA.length && j < slotsB.length) {
            int l = Math.max(slotsA[i][0], slotsB[j][0]);
            int r = Math.min(slotsA[i][1], slotsB[j][1]);
            if (r - l >= dur) {
                return new int[] {l, l + dur};
            }
            if (slotsA[i][1] < slotsB[j][1]) {
                i++;
            } else {
                j++;
            }

        }
        return new int[] {};

    }

    public static void main(String[] args) {
        int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slotsB = {{0, 15}, {60, 70}};
        /*Expected value : [60, 68]*/
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 8)));
        /*Expected value : []*/
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 12)));
    }

}
/**
 Note: overlap
 1. 55----60----70----120   RANGE = {MAX[A1, B1] MIN(A2, B2)}
 A1    B1    B2     A2   [B1, B2] = [60, 70]
 l     r
 2. 55----60----70----120
 B1    A1    A2     B2   [A1, A2] = [60, 70]
 l     r
 3. 55----60----70----120
 B1    A1    B2     A2   [A1, B2] = [60, 70]
 l    r
 4. 55----60----70----120
 A1    B1    A2     B2   [B1, A2] = [60, 70]
 l     r
 5. 55----60----70----120   []
 A1    A2    B1     B2
 r      l
 6. 55----60----70----120   []
 B1    B2    A1     A2
 r      l

 */
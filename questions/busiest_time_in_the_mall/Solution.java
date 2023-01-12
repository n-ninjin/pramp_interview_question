package questions.busiest_time_in_the_mall;

class Solution {


    static int findBusiestPeriod(int[][] data) {
        if (data.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int res = data[0][0];
        int cnt = 0;
        // it is sorted array. if there is more than one period with same visitor peak,
        // return the earlist one.
        for (int i = 0; i < data.length; i++) {
            if (data[i][2] == 1) {
                cnt += data[i][1];
            } else {
                cnt -= data[i][1];
            }

            if (i < data.length - 1 && data[i][0] == data[i + 1][0])
                continue;

            if (max < cnt) {
                max = cnt;
                res = data[i][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] data = { {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0} };
        // Expected output: 1487800378
        // since the increase in the number of people in the mall is the highest at that point
        System.out.println(findBusiestPeriod(data));
        //TC: O(N)
        //SC: O(1)
    }

}
package questions.island_count;

import java.util.LinkedList;
import java.util.Queue;

/*
Island Count
Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.
An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is considered adjacent to another cell if they are next
to each either on the same row or column. Note that two values of 1 are not part of the same island if they’re sharing only a mutual “corner”
(i.e. they are diagonally neighbors).
input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                         [0,    0,    1,    1,    1],
                         [1,    0,    0,    1,    0],
                         [0,    1,    1,    0,    0],
                         [1,    0,    1,    0,    1] ]
output: 6 # since this is the number of islands in binaryMatrix.
          # See all 6 islands color-coded below.
 */
class Solution {

    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        int res = 0;
        int row = binaryMatrix.length;
        int col = binaryMatrix[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (binaryMatrix[r][c] == 1) {
                    //DFS approach
                    dfs(binaryMatrix, r, c);
                    //BFS approach
                    //bfs(binaryMatrix, r, c);
                    res++;
                }
            }
        }
        return res;
    }

    static void dfs(int[][] binaryMatrix, int r, int c) {
        if (r < 0 || r >= binaryMatrix.length ||
                c < 0 || c >= binaryMatrix[r].length || binaryMatrix[r][c] != 1) return;
        binaryMatrix[r][c] = -1;
        dfs(binaryMatrix, r + 1, c);
        dfs(binaryMatrix, r - 1, c);
        dfs(binaryMatrix, r, c + 1);
        dfs(binaryMatrix, r, c - 1);
    }

    static void bfs(int[][] grid, int r, int c) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int curX = cur[0] + dir[0];
                    int curY = cur[1] + dir[1];
                    if (curX < 0 || curX >= m || curY < 0 || curY >= n || grid[curX][curY] != 1) {
                        continue;
                    }
                    grid[curX][curY] = -1;
                    q.add(new int[]{curX, curY});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] binaryMatrix = {{0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}};
        /*
            output: 6 # since this is the number of islands in binaryMatrix.
            See all 6 islands color-coded below.
         */
        System.out.println(getNumberOfIslands(binaryMatrix));
    }

}
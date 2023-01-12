package questions.shortest_cell_path;

/*
Shortest Cell Path
In a given grid of 0s and 1s, we have some starting row and column sr, sc and a target row and column tr, tc. Return the length of the shortest path from sr, sc to tr, tc that walks along 1 values only.
Each location in the path, including the start and the end, must be a 1. Each subsequent location in the path must be 4-directionally adjacent to the previous location.
It is guaranteed that grid[sr][sc] = grid[tr][tc] = 1, and the starting and target positions are different.

Examples
input:
grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 1, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: 8
(The lines below represent this grid:)
1111
0001
1111

grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 0, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: -1
(The lines below represent this grid:)
1111
0001
1011

 */
class Solution {
    static int cnt = 0;

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return helper(grid, sr, sc, tr, tr, visited);

    }

    static int helper(int[][] grid, int sr, int sc, int tr, int tc, boolean[][] visited) {
        if (grid == null || grid.length == 0) return 0;
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == 0 || visited[sr][sc] == true)
            return 0;
        if (sr == tc && sc == tc)
            return cnt;
        visited[sr][sc] = true;
        grid[sr][sc] = 0;
        cnt += helper(grid, sr - 1, sc, tr, tc, visited);
        cnt += helper(grid, sr + 1, sc, tr, tc, visited);
        cnt += helper(grid, sr, sc - 1, tr, tc, visited);
        cnt += helper(grid, sr, sc + 1, tr, tc, visited);
        return -1;

    }

    public static void main(String[] args) {
        // TC: O(R*C)
        // SC: O(R*C)
    }
}

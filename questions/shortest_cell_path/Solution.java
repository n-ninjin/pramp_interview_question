package questions.shortest_cell_path;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        if (grid == null || grid.length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        q.add(new int[]{sr, sc});
        visited.add(new int[]{sr, sc});
        int lvl = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == tr && cur[1] == tc) {
                    return lvl;
                }

                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                            || grid[x][y] == 0 || visited.contains(new int[]{x, y}))
                        continue;
                    grid[x][y] = 0;
                    visited.add(new int[]{x, y});
                    q.add(new int[]{x, y});
                }
            }
            lvl++;
        }
        return -1;

    }


    public static void main(String[] args) {
        // TC: O(R*C)
        // SC: O(R*C)
    }
}

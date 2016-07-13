/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3*/

public class Solution {
    private static final int[][] DIRS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private static final char L = '1', W = '0';

    public void dfsFill(char[][] g, int x, int y) {
        if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == L) {
            g[x][y] = W;
            for (int[] d : DIRS) dfsFill(g, x + d[0], y + d[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == L) {
                    num++;
                    dfsFill(grid, i, j);
                }
            }
        }
        return num;
    }
}
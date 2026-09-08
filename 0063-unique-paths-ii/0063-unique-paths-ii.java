class Solution {

    public int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paths(grid, 0, 0, dp);
    }

    public int paths(int[][] grid, int row, int col, int[][] dp) {

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 1) {
            return 0;
        }

        if (row == grid.length - 1 &&
            col == grid[0].length - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int right = paths(grid, row, col + 1, dp);
        int down = paths(grid, row + 1, col, dp);

        dp[row][col] = right + down;

        return dp[row][col];
    }
}
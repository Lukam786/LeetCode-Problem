class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return paths(obstacleGrid, 0, 0, dp);
    }

    public int paths(int[][] grid, int row, int col, int[][] dp) {

        // Boundary ke bahar
        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        // Obstacle
        if (grid[row][col] == 1) {
            return 0;
        }

        // Destination
        if (row == grid.length - 1 &&
            col == grid[0].length - 1) {
            return 1;
        }

        // Already calculated
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int right = paths(grid, row, col + 1, dp);

        int down = paths(grid, row + 1, col, dp);

        dp[row][col] = right + down;

        return dp[row][col];
    }
}
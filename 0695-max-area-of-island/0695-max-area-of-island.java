
class Solution {

    public int dfs(int[][] grid, int row, int col) {

        // Boundary condition
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        // Mark visited
        grid[row][col] = 0;

        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        return 1 + up + down + left + right;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}

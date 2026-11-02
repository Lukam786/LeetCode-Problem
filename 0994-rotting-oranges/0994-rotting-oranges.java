
class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        // Add all rotten oranges into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Four directions: up, down, left, right
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.remove();

                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {

                    int newRow = r + row[d];
                    int newCol = c + col[d];

                    if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            time++;
        }

        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}

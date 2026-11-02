
class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        // Distance array
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        // Min Heap: {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0, 0, 0});

        // Four directions
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        // Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.remove();

            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == m - 1 && c == n - 1) {
                return effort;
            }

            if (effort > dist[r][c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = r + row[i];
                int newCol = c + col[i];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n) {

                    int difference = Math.abs(
                        heights[r][c] - heights[newRow][newCol]
                    );

                    int newEffort = Math.max(effort, difference);

                    if (newEffort < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newEffort;

                        pq.add(new int[]{
                            newEffort, newRow, newCol
                        });
                    }
                }
            }
        }

        return 0;
    }
}

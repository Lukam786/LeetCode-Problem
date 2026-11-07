class Solution {

    int n;
    int[][] grid;
    int[] size;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        size = new int[n * n + 2];

        int id = 2;

        // Step 1: Find connected components
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(i, j, id);
                    size[id] = area;
                    id++;
                }
            }
        }

        int answer = 0;

        // Step 2: Check existing islands
        for (int i = 2; i < id; i++) {
            answer = Math.max(answer, size[i]);
        }

        // Step 3: Try converting 0 into 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    int area = 1;

                    HashSet<Integer> set = new HashSet<>();

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {

                            int neighborId = grid[nr][nc];

                            if (neighborId > 1 &&
                                set.add(neighborId)) {

                                area += size[neighborId];
                            }
                        }
                    }

                    answer = Math.max(answer, area);
                }
            }
        }

        return answer;
    }

    public int dfs(int r, int c, int id) {

        if (r < 0 || r >= n || c < 0 || c >= n ||
            grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = id;

        int area = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            area += dfs(nr, nc, id);
        }

        return area;
    }
}
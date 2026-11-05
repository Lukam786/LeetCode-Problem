class Solution {

    public int removeStones(int[][] stones) {

        int n = stones.length;
        boolean[] visited = new boolean[n];

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i, stones, visited);
                components++;
            }
        }

        return n - components;
    }

    public void dfs(int curr, int[][] stones, boolean[] visited) {

        visited[curr] = true;

        for (int i = 0; i < stones.length; i++) {

            if (!visited[i]) {

                if (stones[curr][0] == stones[i][0] ||
                    stones[curr][1] == stones[i][1]) {

                    dfs(i, stones, visited);
                }
            }
        }
    }
}
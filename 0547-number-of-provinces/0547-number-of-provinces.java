
class Solution {

    public void dfs(int[][] isConnected, int curr, boolean[] vis) {

        vis[curr] = true;

        for (int i = 0; i < isConnected.length; i++) {

            if (isConnected[curr][i] == 1 && !vis[i]) {

                dfs(isConnected, i, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] vis = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                count++;

                dfs(isConnected, i, vis);
            }
        }

        return count;
    }
}

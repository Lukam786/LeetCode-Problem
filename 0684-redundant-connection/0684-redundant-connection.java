
class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean vis[] = new boolean[n + 1];

            if (dfs(graph, u, v, vis)) {
                return edge;
            }

            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }

    public boolean dfs(ArrayList<Integer>[] graph,
                       int curr, int target, boolean vis[]) {

        if (curr == target) {
            return true;
        }

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            int neighbor = graph[curr].get(i);

            if (!vis[neighbor]) {

                if (dfs(graph, neighbor, target, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}

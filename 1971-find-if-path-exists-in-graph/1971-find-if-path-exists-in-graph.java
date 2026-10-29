
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, source, destination, visited);
    }

    public boolean dfs(ArrayList<Integer>[] graph, int curr,
                       int destination, boolean[] visited) {

        if (curr == destination) {
            return true;
        }

        visited[curr] = true;

        for (int neighbor : graph[curr]) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

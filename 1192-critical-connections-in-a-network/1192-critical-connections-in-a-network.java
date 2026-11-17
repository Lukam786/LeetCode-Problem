
class Solution {

    public void dfs(ArrayList<Integer>[] graph, int curr, int parent,
                    int discovery[], int low[], boolean vis[],
                    int timer[], List<List<Integer>> ans) {

        vis[curr] = true;

        discovery[curr] = low[curr] = ++timer[0];

        for(int neigh : graph[curr]) {

            if(neigh == parent) {
                continue;
            }

            if(!vis[neigh]) {

                dfs(graph, neigh, curr, discovery, low,
                    vis, timer, ans);

                low[curr] = Math.min(low[curr], low[neigh]);

                if(low[neigh] > discovery[curr]) {

                    ans.add(Arrays.asList(curr, neigh));
                }
            }

            else {

                low[curr] = Math.min(low[curr], discovery[neigh]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(
        int n, List<List<Integer>> connections) {

        // Step 1: Create Adjacency List

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Convert connections into adjacency list

        for(List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        // Step 3: Initialize arrays

        int discovery[] = new int[n];
        int low[] = new int[n];

        boolean vis[] = new boolean[n];

        int timer[] = new int[1];

        List<List<Integer>> ans = new ArrayList<>();

        // Step 4: DFS traversal

        for(int i = 0; i < n; i++) {

            if(!vis[i]) {

                dfs(graph, i, -1, discovery, low,
                    vis, timer, ans);
            }
        }

        return ans;
    }
}

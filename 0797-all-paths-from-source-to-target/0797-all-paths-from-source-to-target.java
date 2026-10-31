
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, graph.length - 1, graph, path, result);

        return result;
    }

    public void dfs(int node, int target, int[][] graph,
                    List<Integer> path,
                    List<List<Integer>> result) {

        path.add(node);

        if (node == target) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int neighbour : graph[node]) {
            dfs(neighbour, target, graph, path, result);
        }

        path.remove(path.size() - 1);
    }
}

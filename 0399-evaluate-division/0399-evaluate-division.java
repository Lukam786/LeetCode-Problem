
class Solution {
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> vis = new HashSet<>();
                ans[i] = dfs(src, dest, 1.0, graph, vis);
            }
        }

        return ans;
    }

    public double dfs(
        String src,
        String dest,
        double product,
        Map<String, Map<String, Double>> graph,
        Set<String> vis
    ) {
        if (src.equals(dest)) {
            return product;
        }

        vis.add(src);

        for (String next : graph.get(src).keySet()) {
            if (!vis.contains(next)) {
                double result = dfs(
                    next, dest,
                    product * graph.get(src).get(next),
                    graph, vis
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}


class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {

        // Create adjacency list
        ArrayList<double[]> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add undirected edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            double prob = succProb[i];

            graph[u].add(new double[]{v, prob});
            graph[v].add(new double[]{u, prob});
        }

        // Maximum probability array
        double[] dist = new double[n];

        dist[start_node] = 1.0;

        // Max Heap: {probability, node}
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        pq.add(new double[]{1.0, start_node});

        // Dijkstra
        while (!pq.isEmpty()) {

            double[] curr = pq.remove();

            double probability = curr[0];
            int node = (int) curr[1];

            if (node == end_node) {
                return probability;
            }

            if (probability < dist[node]) {
                continue;
            }

            for (int i = 0; i < graph[node].size(); i++) {

                double[] edge = graph[node].get(i);

                int neighbor = (int) edge[0];
                double weight = edge[1];

                double newProbability = probability * weight;

                if (newProbability > dist[neighbor]) {

                    dist[neighbor] = newProbability;

                    pq.add(new double[]{newProbability, neighbor});
                }
            }
        }

        return 0.0;
    }
}

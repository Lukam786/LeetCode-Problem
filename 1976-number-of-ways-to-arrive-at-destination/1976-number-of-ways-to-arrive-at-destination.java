
class Solution {

    public int countPaths(int n, int[][] roads) {

        // Create adjacency list
        ArrayList<long[]> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add undirected edges
        for (int i = 0; i < roads.length; i++) {

            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];

            graph[u].add(new long[]{v, time});
            graph[v].add(new long[]{u, time});
        }

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;

        int mod = 1000000007;

        // Min Heap: {distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        pq.add(new long[]{0, 0});

        // Dijkstra
        while (!pq.isEmpty()) {

            long[] curr = pq.remove();

            long distance = curr[0];
            int node = (int) curr[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int i = 0; i < graph[node].size(); i++) {

                long[] edge = graph[node].get(i);

                int neighbor = (int) edge[0];
                long weight = edge[1];

                long newDistance = distance + weight;

                // Found shorter path
                if (newDistance < dist[neighbor]) {

                    dist[neighbor] = newDistance;

                    ways[neighbor] = ways[node];

                    pq.add(new long[]{newDistance, neighbor});
                }

                // Found another shortest path
                else if (newDistance == dist[neighbor]) {

                    ways[neighbor] =
                        (ways[neighbor] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}

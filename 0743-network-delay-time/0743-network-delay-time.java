
class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Create adjacency list
        ArrayList<int[]> graph[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        for (int i = 0; i < times.length; i++) {

            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            graph[u].add(new int[]{v, w});
        }

        // Distance array
        int dist[] = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min Heap: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0, k});

        // Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.remove();

            int distance = curr[0];
            int node = curr[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int i = 0; i < graph[node].size(); i++) {

                int[] edge = graph[node].get(i);

                int neighbor = edge[0];
                int weight = edge[1];

                int newDistance = distance + weight;

                if (newDistance < dist[neighbor]) {

                    dist[neighbor] = newDistance;

                    pq.add(new int[]{newDistance, neighbor});
                }
            }
        }

        // Find maximum shortest distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}

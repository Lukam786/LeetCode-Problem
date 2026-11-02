
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create adjacency list
        ArrayList<int[]> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add directed edges
        for (int i = 0; i < flights.length; i++) {

            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];

            graph[u].add(new int[]{v, price});
        }

        // Distance array
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Queue: {node, cost, stops}
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {

            int[] curr = q.remove();

            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // Maximum allowed stops
            if (stops > k) {
                continue;
            }

            for (int i = 0; i < graph[node].size(); i++) {

                int[] edge = graph[node].get(i);

                int neighbor = edge[0];
                int price = edge[1];

                int newCost = cost + price;

                if (newCost < dist[neighbor]) {

                    dist[neighbor] = newCost;

                    q.add(new int[]{
                        neighbor, newCost, stops + 1
                    });
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}

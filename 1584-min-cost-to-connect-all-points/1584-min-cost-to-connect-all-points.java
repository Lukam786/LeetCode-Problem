class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] vis = new boolean[n];
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{0, 0});

        int result = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int u = curr[0];
            int cost = curr[1];

            if (vis[u]) {
                continue;
            }

            vis[u] = true;
            result += cost;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int distance = Math.abs(points[u][0] - points[v][0])
                                 + Math.abs(points[u][1] - points[v][1]);

                    if (distance < dist[v]) {
                        dist[v] = distance;
                        pq.add(new int[]{v, distance});
                    }
                }
            }
        }

        return result;
    }
}
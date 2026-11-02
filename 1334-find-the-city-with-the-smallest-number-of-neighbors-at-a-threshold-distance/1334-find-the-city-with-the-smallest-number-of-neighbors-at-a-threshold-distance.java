
class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {

            Arrays.fill(dist[i], 100000000);

            dist[i][i] = 0;
        }

        // Add edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            dist[u][v] = weight;
            dist[v][u] = weight;
        }

        // Floyd-Warshall Algorithm
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][via] != 100000000 &&
                        dist[via][j] != 100000000) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][via] + dist[via][j]
                        );
                    }
                }
            }
        }

        int answer = -1;
        int smallestCount = Integer.MAX_VALUE;

        // Count reachable cities
        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= smallestCount) {

                smallestCount = count;

                answer = i;
            }
        }

        return answer;
    }
}

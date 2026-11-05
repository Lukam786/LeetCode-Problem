class Solution {

    int[] parent;
    int[] rank;

    public int makeConnected(int n, int[][] connections) {

        // Not enough cables
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int components = n;

        // Process all connections
        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            if (union(u, v)) {
                components--;
            }
        }

        // Required operations = components - 1
        return components - 1;
    }

    // Find with Path Compression
    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union by Rank
    public boolean union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return false;
        }

        if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        }
        else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        }
        else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }

        return true;
    }
}
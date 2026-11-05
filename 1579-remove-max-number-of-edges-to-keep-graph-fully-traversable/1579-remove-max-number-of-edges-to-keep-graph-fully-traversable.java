class Solution {

    int[] parent;
    int[] rank;

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int[] parentA = new int[n + 1];
        int[] rankA = new int[n + 1];

        int[] parentB = new int[n + 1];
        int[] rankB = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }

        int usedEdges = 0;

        // Type 3: Alice and Bob both can use
        for (int[] edge : edges) {

            if (edge[0] == 3) {

                boolean mergedA = union(parentA, rankA, edge[1], edge[2]);
                boolean mergedB = union(parentB, rankB, edge[1], edge[2]);

                if (mergedA || mergedB) {
                    usedEdges++;
                }
            }
        }

        // Type 1: Alice only
        for (int[] edge : edges) {

            if (edge[0] == 1) {

                if (union(parentA, rankA, edge[1], edge[2])) {
                    usedEdges++;
                }
            }
        }

        // Type 2: Bob only
        for (int[] edge : edges) {

            if (edge[0] == 2) {

                if (union(parentB, rankB, edge[1], edge[2])) {
                    usedEdges++;
                }
            }
        }

        // Check connectivity
        int rootA = find(parentA, 1);
        int rootB = find(parentB, 1);

        for (int i = 2; i <= n; i++) {

            if (find(parentA, i) != rootA ||
                find(parentB, i) != rootB) {

                return -1;
            }
        }

        return edges.length - usedEdges;
    }

    // Find with Path Compression
    public int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    // Union by Rank
    public boolean union(int[] parent, int[] rank, int a, int b) {

        int parentA = find(parent, a);
        int parentB = find(parent, b);

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
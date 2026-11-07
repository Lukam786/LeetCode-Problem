class Solution {
    int[] parent;
    int[] rank;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int points = (n + 1) * (n + 1);

        parent = new int[points];
        rank = new int[points];

        for (int i = 0; i < points; i++) {
            parent[i] = i;
        }

        int regions = 1;

        // Connect boundary points to the outside region
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0 || i == n || j == n) {
                    int index = i * (n + 1) + j;

                    if (index != 0) {
                        union(0, index);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int cell = i * (n + 1) + j;

                if (grid[i].charAt(j) == '/') {
                    int topRight = cell + 1;
                    int bottomLeft = cell + n + 1;

                    if (!union(topRight, bottomLeft)) {
                        regions++;
                    }
                }
                else if (grid[i].charAt(j) == '\\') {
                    int topLeft = cell;
                    int bottomRight = cell + n + 2;

                    if (!union(topLeft, bottomRight)) {
                        regions++;
                    }
                }
            }
        }

        return regions;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        }
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }
}
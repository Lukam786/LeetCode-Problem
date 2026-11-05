class Solution {

    int[] parent;
    int[] rank;

    public boolean equationsPossible(String[] equations) {

        parent = new int[26];
        rank = new int[26];

        // Initialize DSU
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // First process all equality equations
        for (String equation : equations) {

            if (equation.charAt(1) == '=') {

                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                union(a, b);
            }
        }

        // Then process all inequality equations
        for (String equation : equations) {

            if (equation.charAt(1) == '!') {

                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                if (find(a) == find(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Find with Path Compression
    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union by Rank
    public void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
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
    }
}
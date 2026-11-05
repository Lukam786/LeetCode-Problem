class Solution {

    int[] parent;
    int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();

        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union all connected indices
        for (List<Integer> pair : pairs) {

            int a = pair.get(0);
            int b = pair.get(1);

            union(a, b);
        }

        // Store characters according to their components
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = find(i);

            map.putIfAbsent(root, new PriorityQueue<>());

            map.get(root).offer(s.charAt(i));
        }

        // Build smallest possible string
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int root = find(i);

            result.append(map.get(root).poll());
        }

        return result.toString();
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
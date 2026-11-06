class Solution {

    static class DSU {
        int[] par;
        int[] rank;

        DSU(int n) {
            par = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        int find(int x) {
            if (par[x] != x) {
                par[x] = find(par[x]);
            }
            return par[x];
        }

        boolean union(int a, int b) {
            int parA = find(a);
            int parB = find(b);

            if (parA == parB) {
                return false;
            }

            if (rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            } else if (rank[parA] > rank[parB]) {
                par[parB] = parA;
            } else {
                par[parA] = parB;
            }

            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
        int n, int[][] edges) {

        int m = edges.length;

        int[][] arr = new int[m][4];

        for (int i = 0; i < m; i++) {
            arr[i][0] = edges[i][0];
            arr[i][1] = edges[i][1];
            arr[i][2] = edges[i][2];
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> a[2] - b[2]);

        int mst = kruskal(n, arr, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int without = kruskal(n, arr, i, -1);

            if (without > mst) {
                critical.add(arr[i][3]);
            } else {
                int with = kruskal(n, arr, -1, i);

                if (with == mst) {
                    pseudo.add(arr[i][3]);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        result.add(critical);
        result.add(pseudo);

        return result;
    }

    private int kruskal(int n, int[][] edges, int skip, int force) {

        DSU dsu = new DSU(n);

        int cost = 0;
        int count = 0;

        if (force != -1) {
            int u = edges[force][0];
            int v = edges[force][1];
            int w = edges[force][2];

            dsu.union(u, v);
            cost += w;
            count++;
        }

        for (int i = 0; i < edges.length; i++) {

            if (i == skip || i == force) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (dsu.union(u, v)) {
                cost += w;
                count++;
            }
        }

        if (count != n - 1) {
            return Integer.MAX_VALUE;
        }

        return cost;
    }
}
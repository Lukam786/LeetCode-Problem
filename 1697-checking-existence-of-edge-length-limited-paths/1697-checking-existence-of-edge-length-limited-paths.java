import java.util.*;

class Solution {

    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
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
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public boolean[] distanceLimitedPathsExist(
        int n, int[][] edgeList, int[][] queries) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(edgeList, (a, b) -> 
            Integer.compare(a[2], b[2]));

        int[][] sortedQueries = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = queries[i][2];
            sortedQueries[i][3] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> 
            Integer.compare(a[2], b[2]));

        boolean[] answer = new boolean[queries.length];

        int edgeIndex = 0;

        for (int i = 0; i < sortedQueries.length; i++) {

            int source = sortedQueries[i][0];
            int destination = sortedQueries[i][1];
            int limit = sortedQueries[i][2];
            int originalIndex = sortedQueries[i][3];

            while (edgeIndex < edgeList.length &&
                   edgeList[edgeIndex][2] < limit) {

                int u = edgeList[edgeIndex][0];
                int v = edgeList[edgeIndex][1];

                union(u, v);

                edgeIndex++;
            }

            answer[originalIndex] = connected(source, destination);
        }

        return answer;
    }
}
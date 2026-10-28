class Solution {

    static boolean checkUsingBfs(int source, int graph[][], int color[]) {

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[source] = 0;

        while (q.isEmpty() == false) {

            int curr = q.remove();
            int currColor = color[curr];

            for (int conn : graph[curr]) {

                if (color[conn] == -1) {
                    // if conn is not colored
                    color[conn] = 1 - currColor;
                    q.add(conn);
                } else {
                    // already colored
                    if (currColor == color[conn]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int color[] = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                boolean result = checkUsingBfs(i, graph, color);

                if (result == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
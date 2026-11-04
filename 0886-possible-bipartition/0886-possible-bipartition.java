
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {

                Queue<Integer> q = new ArrayDeque<>();

                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {

                        int neighbor = graph[curr].get(j);

                        if (color[neighbor] == 0) {

                            color[neighbor] = -color[curr];
                            q.add(neighbor);

                        } 
                        else if (color[neighbor] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

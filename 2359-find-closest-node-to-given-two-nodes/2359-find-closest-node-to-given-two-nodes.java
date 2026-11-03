
class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        int dist1[] = new int[n];
        int dist2[] = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            if(dist1[i] != -1 && dist2[i] != -1) {

                int maxDist = Math.max(dist1[i], dist2[i]);

                if(maxDist < minDist) {
                    minDist = maxDist;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public void bfs(int edges[], int start, int dist[]) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {

            int curr = q.remove();

            int next = edges[curr];

            if(next != -1 && dist[next] == -1) {

                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }
    }
}
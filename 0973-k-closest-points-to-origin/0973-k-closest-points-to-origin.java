
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                int distanceA = a[0] * a[0] + a[1] * a[1];
                int distanceB = b[0] * b[0] + b[1] * b[1];

                return distanceB - distanceA;
            }
        );

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] answer = new int[k][2];

        for (int i = 0; i < k; i++) {
            answer[i] = pq.remove();
        }

        return answer;
    }
}

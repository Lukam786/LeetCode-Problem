
import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            }
        );

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                }
            }

            pq.add(new int[]{i, soldiers});
        }

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            int[] current = pq.remove();
            answer[i] = current[0];
        }

        return answer;
    }
}

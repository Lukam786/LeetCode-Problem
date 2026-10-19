
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int answer = 0;

        for (int count = 0; count < k; count++) {
            int[] current = pq.remove();

            answer = current[0];

            int row = current[1];
            int col = current[2];

            if (col + 1 < n) {
                int nextCol = col + 1;
                int nextValue = matrix[row][nextCol];

                pq.add(new int[]{nextValue, row, nextCol});
            }
        }

        return answer;
    }
}

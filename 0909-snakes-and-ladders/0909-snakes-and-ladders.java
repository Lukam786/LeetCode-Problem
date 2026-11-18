
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();

            int pos = curr[0];
            int moves = curr[1];

            if (pos == n * n) {
                return moves;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;

                if (next > n * n) {
                    break;
                }

                int row = n - 1 - (next - 1) / n;
                int col = (next - 1) % n;

                if ((n - 1 - row) % 2 == 1) {
                    col = n - 1 - col;
                }

                if (board[row][col] != -1) {
                    next = board[row][col];
                }

                if (!vis[next]) {
                    vis[next] = true;
                    q.add(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }
}

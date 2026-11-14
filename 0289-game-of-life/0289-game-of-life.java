class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int dir[][] = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},           {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;

                for (int d = 0; d < 8; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && r < m && c >= 0 && c < n
                        && (board[r][c] == 1 || board[r][c] == 2)) {
                        live++;
                    }
                }

                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        // 1. Empty cell find karo
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // 2. 1 se 9 tak try karo
                    for (char num = '1'; num <= '9'; num++) {

                        // 3. Check karo number safe hai ya nahi
                        if (isSafe(board, row, col, num)) {

                            // 4. Number place karo
                            board[row][col] = num;

                            // 5. Next empty cell ke liye recursion
                            if (solve(board)) {
                                return true;
                            }

                            // 6. Galat choice thi → backtrack
                            board[row][col] = '.';
                        }
                    }

                    // Koi bhi number kaam nahi kiya
                    return false;
                }
            }
        }

        // Koi empty cell nahi bacha
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char num) {

        // Same row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Same column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Same 3x3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
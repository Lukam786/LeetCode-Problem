class Solution {

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        // Board ko '.' se fill karo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return nQueens(board, 0);
    }

    public int nQueens(char[][] board, int row) {

        // Base case
        if (row == board.length) {
            return 1;
        }

        int count = 0;

        // Har column mein Queen try karo
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Choose
                board[row][col] = 'Q';

                // Recursion
                count += nQueens(board, row + 1);

                // Backtracking
                board[row][col] = '.';
            }
        }

        return count;
    }

    public boolean isSafe(char[][] board, int row, int col) {

        // Same column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
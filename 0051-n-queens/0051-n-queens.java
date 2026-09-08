class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Board ko '.' se fill karna
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(board, 0, result);

        return result;
    }

    public void nQueens(char[][] board, int row,
                        List<List<String>> result) {

        // Base case
        if (row == board.length) {

            List<String> solution = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        // Har column mein Queen try karo
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Queen place
                board[row][col] = 'Q';

                // Next row
                nQueens(board, row + 1, result);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {

        // Same column check
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
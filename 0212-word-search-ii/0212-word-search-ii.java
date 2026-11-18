
class Solution {

    static class Node {
        Node[] children = new Node[26];
        String word;
    }

    Node root = new Node();

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        // Insert all words into Trie
        for (String word : words) {
            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void dfs(char[][] board, int row, int col,
                    Node curr, List<String> ans) {

        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];
        int idx = ch - 'a';

        if (curr.children[idx] == null) {
            return;
        }

        curr = curr.children[idx];

        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null;
        }

        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col, curr, ans);

        // Down
        dfs(board, row + 1, col, curr, ans);

        // Left
        dfs(board, row, col - 1, curr, ans);

        // Right
        dfs(board, row, col + 1, curr, ans);

        // Backtracking
        board[row][col] = ch;
    }
}

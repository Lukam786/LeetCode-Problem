
class WordDictionary {

    static class Node {
        Node[] children = new Node[26];
        boolean eow;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node curr) {

        if (index == word.length()) {
            return curr.eow;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (dfs(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }

            return false;
        }

        int idx = ch - 'a';

        if (curr.children[idx] == null) {
            return false;
        }

        return dfs(word, index + 1, curr.children[idx]);
    }
}

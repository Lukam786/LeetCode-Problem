
class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        boolean found = false;

        // BFS
        while (!q.isEmpty() && !found) {

            int size = q.size();

            HashSet<String> visited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = q.remove();

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        arr[j] = ch;

                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            map.putIfAbsent(newWord, new ArrayList<>());

                            map.get(newWord).add(word);

                            if (!visited.contains(newWord)) {

                                visited.add(newWord);

                                q.add(newWord);
                            }

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            set.removeAll(visited);
        }

        // DFS
        if (found) {

            List<String> path = new ArrayList<>();

            path.add(endWord);

            dfs(endWord, beginWord, map, path, result);
        }

        return result;
    }

    private void dfs(String word, String beginWord,
                     HashMap<String, List<String>> map,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            result.add(temp);

            return;
        }

        if (!map.containsKey(word)) {
            return;
        }

        for (String previous : map.get(word)) {

            path.add(previous);

            dfs(previous, beginWord, map, path, result);

            path.remove(path.size() - 1);
        }
    }
}

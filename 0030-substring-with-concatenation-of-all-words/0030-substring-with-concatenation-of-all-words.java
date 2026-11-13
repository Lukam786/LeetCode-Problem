
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowLength = wordLength * totalWords;

        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (!required.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > required.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);

                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }

                if (count == totalWords) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLength);
                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += wordLength;
                    count--;
                }
            }
        }

        return result;
    }
}

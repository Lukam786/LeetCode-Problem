
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;

        int maxC = 0;
        int max = 0;

        int[] counts = new int[26];

        while (j < s.length()) {
            char c = s.charAt(j);

            counts[c - 'A'] = counts[c - 'A'] + 1;

            maxC = Math.max(maxC, counts[c - 'A']);

            while ((j - i + 1) - maxC > k) {
                char d = s.charAt(i);

                counts[d - 'A'] = counts[d - 'A'] - 1;

                i = i + 1;
            }

            max = Math.max(max, j - i + 1);

            j = j + 1;
        }

        return max;
    }
}

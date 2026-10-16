
class Solution {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = new int[combined.length()];

        int j = 0;

        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int longestPrefix = lps[combined.length() - 1];

        String remaining = s.substring(longestPrefix);
        String result = new StringBuilder(remaining).reverse().toString()
                + s;

        return result;
    }
}

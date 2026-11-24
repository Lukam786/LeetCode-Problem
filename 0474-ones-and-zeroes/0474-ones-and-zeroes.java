
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        for (int k = 0; k < strs.length; k++) {

            int zero = 0;
            int one = 0;

            for (int i = 0; i < strs[k].length(); i++) {

                if (strs[k].charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }

            for (int i = m; i >= zero; i--) {

                for (int j = n; j >= one; j--) {

                    dp[i][j] = Math.max(
                        dp[i][j],
                        1 + dp[i - zero][j - one]
                    );
                }
            }
        }

        return dp[m][n];
    }
}


class Solution {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;

        boolean dp[] = new boolean[target + 1];

        dp[0] = true;

        for (int i = 0; i < stones.length; i++) {

            for (int j = target; j >= stones[i]; j--) {

                dp[j] = dp[j] || dp[j - stones[i]];
            }
        }

        for (int j = target; j >= 0; j--) {

            if (dp[j]) {
                return sum - 2 * j;
            }
        }

        return 0;
    }
}

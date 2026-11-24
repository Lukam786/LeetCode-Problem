
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int newTarget = (sum + target) / 2;

        int dp[] = new int[newTarget + 1];

        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {

            for (int j = newTarget; j >= nums[i]; j--) {

                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[newTarget];
    }
}

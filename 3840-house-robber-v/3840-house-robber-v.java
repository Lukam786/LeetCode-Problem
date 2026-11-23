
class Solution {

    public long rec(int i, int[] nums, int[] colors, long[] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Not Take: Current house skip
        long notTake = rec(i + 1, nums, colors, dp);

        // Take: Current house rob
        long take = nums[i];

        if (i + 1 < nums.length) {

            if (colors[i] == colors[i + 1]) {
                take += rec(i + 2, nums, colors, dp);
            } else {
                take += rec(i + 1, nums, colors, dp);
            }
        }

        long ans = Math.max(take, notTake);

        dp[i] = ans;

        return ans;
    }

    public long rob(int[] nums, int[] colors) {

        int n = nums.length;

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return rec(0, nums, colors, dp);
    }
}

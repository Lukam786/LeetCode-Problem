class Solution {

    public int rec(int i, int[] nums, int n, int[] dp) {

        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + rec(i + 2, nums, n, dp);

        int notTake = rec(i + 1, nums, n, dp);

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int dp1[] = new int[n];
        int dp2[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }

        int takeFirst = nums[0] + rec(2, nums, n - 1, dp1);

        int notTakeFirst = rec(1, nums, n, dp2);

        return Math.max(takeFirst, notTakeFirst);
    }
}
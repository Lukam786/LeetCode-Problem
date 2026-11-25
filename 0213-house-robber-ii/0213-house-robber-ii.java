class Solution {

    int rec(int i, int nums[], int n, int dp[]) {

        if (i >= n) {   // society ends
            return 0;
        }

        // if the overlapping subproblem is already calculated,
        // don't calculate again, just return it
        if (dp[i] != -1) {
            return dp[i];
        }

        int takeMoney = nums[i] + rec(i + 2, nums, n, dp);

        int dontTake = rec(i + 1, nums, n, dp);

        int mx = Math.max(takeMoney, dontTake);

        dp[i] = mx;

        return mx;
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

        return Math.max(
                nums[0] + rec(2, nums, n - 1, dp1),
                rec(1, nums, n, dp2)
        );
    }
}
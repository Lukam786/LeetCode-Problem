
import java.util.Arrays;

class Solution {

    public int helper(int[] memo, int[] nums, int n) {

        if(n <= 0) return 0;

        if(memo[n] != -1) return memo[n];

        int val1 = nums[n-1] + helper(memo, nums, n-2);

        int val2 = helper(memo, nums, n-1);

        return memo[n] = Math.max(val1, val2);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        int[] memo = new int[n+1];

        Arrays.fill(memo, -1);

        return helper(memo, nums, n);
    }
}

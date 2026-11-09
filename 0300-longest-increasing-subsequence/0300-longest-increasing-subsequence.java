
class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        int len = 0;

        for (int num : nums) {

            int low = 0;
            int high = len;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (dp[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            dp[low] = num;

            if (low == len) {
                len++;
            }
        }

        return len;
    }
}

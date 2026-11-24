
class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int maxResult = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            maxResult = Math.max(maxResult, j - i);
        }

        return maxResult;
    }
}

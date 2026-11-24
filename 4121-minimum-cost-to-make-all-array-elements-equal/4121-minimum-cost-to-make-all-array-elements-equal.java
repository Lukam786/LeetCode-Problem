
class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long minCost = Long.MAX_VALUE;

        int i = 0;

        while (i < n) {
            int j = i;

            // Find consecutive equal elements
            while (j + 1 < n && nums[j] == nums[j + 1]) {
                j++;
            }

            // Check whether this group can be used
            if (!(i == 0 && j == 0) &&
                !(i == n - 1 && j == n - 1)) {

                long value = nums[i];

                // Elements outside this group
                long elements = i + (n - j - 1);

                long cost = elements * value;

                minCost = Math.min(minCost, cost);
            }

            i = j + 1;
        }

        return minCost;
    }
}


class Solution {

    public boolean isPossible(int[] nums, int k, int mid) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= mid) {

                count++;

                i++; // Skip adjacent house
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }

    public int minCapability(int[] nums, int k) {

        int low = nums[0];
        int high = nums[0];

        for (int i = 0; i < nums.length; i++) {

            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}

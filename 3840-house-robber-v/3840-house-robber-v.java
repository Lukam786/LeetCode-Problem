
class Solution {

    public long rob(int[] nums, int[] colors) {

        int n = nums.length;

        long notTake = 0;
        long take = nums[0];

        for (int i = 1; i < n; i++) {

            long newTake;

            if (colors[i] == colors[i - 1]) {

                newTake = notTake + nums[i];

            } else {

                newTake = Math.max(take, notTake) + nums[i];
            }

            long newNotTake = Math.max(take, notTake);

            take = newTake;
            notTake = newNotTake;
        }

        return Math.max(take, notTake);
    }
}

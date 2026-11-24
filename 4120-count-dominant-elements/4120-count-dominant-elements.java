
class Solution {
    public int countDominantElements(int[] nums) {
        int count = 0;

        if(nums.length == 1){
            return 1;
        }

        // First element
        if(nums[0] >= nums[1]){
            count++;
        }

        // Last element
        if(nums[nums.length - 1] >= nums[nums.length - 2]){
            count++;
        }

        // Middle elements
        for(int i = 1; i < nums.length - 1; i++){
            if(2 * nums[i] >= nums[i - 1] + nums[i + 1]){
                count++;
            }
        }

        return count;
    }
}

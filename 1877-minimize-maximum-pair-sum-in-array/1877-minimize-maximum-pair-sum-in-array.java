class Solution {
    public int minPairSum(int[] nums) {
       int left=0;
       int right=nums.length-1;
       int maximum=0;
       Arrays.sort(nums);
       while(left<right){
         maximum=Math.max(nums[left]+nums[right],maximum);
         left++;
         right--;
       }
       return maximum;
    }
}
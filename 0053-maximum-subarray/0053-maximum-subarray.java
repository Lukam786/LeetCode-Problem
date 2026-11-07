class Solution {
    public int maxSubArray(int[] nums) {
       int MaxSub=nums[0];
       int CurrSum=nums[0];
       for(int i=1; i<nums.length; i++){
        CurrSum=Math.max(nums[i],CurrSum+nums[i]);
        MaxSub=Math.max(CurrSum,MaxSub);
       }
       return MaxSub;
    }
}
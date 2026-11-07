class Solution {
    public int findDuplicate(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[nums[i]]++;
            if(ans[nums[i]]==2){
                return nums[i];
            }
        }
        return -1;
    }
}
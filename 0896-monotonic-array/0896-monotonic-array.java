class Solution {
    public boolean isMonotonic(int[] nums) {
       boolean Increasing=true;
       boolean Decreasing=true;
       for(int i=0; i<nums.length-1; i++){
        if(nums[i]>nums[i+1]){
            Increasing=false;
        }
         if(nums[i]<nums[i+1]){
            Decreasing=false;
        }
       }
       return Increasing||Decreasing;
    }
}
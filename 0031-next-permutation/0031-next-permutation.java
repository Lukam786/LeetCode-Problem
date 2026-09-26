class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
         int temp=nums[j];
         nums[j]=nums[i];
         nums[i]=temp;
           
         reverse(nums, i+1, nums.length-1);
    }
      public void reverse(int nums[],int left,int right){
            while(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }
        
}
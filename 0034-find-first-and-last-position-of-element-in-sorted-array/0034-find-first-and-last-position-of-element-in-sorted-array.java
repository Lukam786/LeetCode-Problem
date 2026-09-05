class Solution {
    public int[] searchRange(int[] nums, int target) {
        int si=firstOccurance(nums,target);
        int ei=lastOccurance(nums,target);
        return new int[]{si,ei}; 
    }
    public int firstOccurance(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                ans=mid;
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;

    }
    public int lastOccurance(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                ans=mid;
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;

    }

}
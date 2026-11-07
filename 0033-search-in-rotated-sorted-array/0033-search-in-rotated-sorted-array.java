class Solution {
    public int search(int[] nums, int target) {
        int n =nums.length;
        int left=0; 
        int right=n-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        int shift=left;
        left=0;
        right=n-1;
        while(left<=right){
          int  mid=(left+right)/2;
            int realmid=(shift+mid)%n;
            if(nums[realmid]==target){
                return realmid;
            }
            else if(nums[realmid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
        
    }
}
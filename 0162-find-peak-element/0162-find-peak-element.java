class Solution {
    public int findPeakElement(int[] nums) {
        int si=0;
        int ei=nums.length-1;
        while(si<ei){
            int mid=(si+ei)/2;
            if(nums[mid]<nums[mid+1]){
                si=mid+1;
            }
            else{
                ei=mid;
            }
        }
        return si;
    }
}
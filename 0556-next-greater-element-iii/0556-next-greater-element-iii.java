class Solution {
    public int nextGreaterElement(int n) {
        char nums[]=String.valueOf(n).toCharArray();
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i==-1){
            return -1;
        }
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        char temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;

        int left=i+1;
        int right=nums.length-1;
        while(left<right){
             temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        long ans=Long.parseLong(new String(nums));
        if(ans>Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;
    }
}
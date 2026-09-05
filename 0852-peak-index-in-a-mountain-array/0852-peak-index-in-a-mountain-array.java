class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int si=0;
        int ei=arr.length-1;
        while(si<ei){
            int mid=(si+ei)/2;
            if(arr[mid]<arr[mid+1]){
                si=mid+1;
            }
            else{
                ei=mid;
            }
        }
        return si;
        
    }
}
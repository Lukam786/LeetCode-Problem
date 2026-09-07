class Solution {
    public int maxArea(int[] height) {
        int si=0;
        int ei=height.length-1;
        int maxwater=0;
        while(si<ei){
            int Height=Math.min(height[si],height[ei]);
          int  width=ei-si;
            int waterlevel=Height*width;
            maxwater=Math.max(maxwater,waterlevel);
            if(height[si]<height[ei]){
                si++;
            }
            else{
                ei--;
            }
        }
        return maxwater;
        
    }
}
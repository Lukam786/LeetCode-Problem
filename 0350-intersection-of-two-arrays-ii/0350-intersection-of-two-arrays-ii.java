class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            int num=nums1[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        int ans[]=new int[Math.min(nums1.length,nums2.length)];
        int index=0;
        for(int i=0; i<nums2.length; i++){
            int num2=nums2[i];
            if(map.containsKey(num2)&& map.get(num2)>0){
                ans[index]=num2;
                index++;
                map.put(num2,map.get(num2)-1);
            }
        }
       int result[]=new int[index];
       for(int i=0; i<index; i++){
          result[i]=ans[i];
       }
       return result;
    }
}
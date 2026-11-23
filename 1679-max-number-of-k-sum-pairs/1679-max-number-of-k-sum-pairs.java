class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            int remaining=k-num;
            if(map.containsKey(remaining)){
               count++;
               int freq=map.get(remaining);
               if(freq==1){
                map.remove(remaining);
               }
               else{
                map.put(remaining,freq-1);
               }
            }
            else{
                 map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
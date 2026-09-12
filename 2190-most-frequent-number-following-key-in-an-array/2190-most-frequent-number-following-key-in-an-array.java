class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int count=0;
        int ans=0;
        for(int i=0; i<nums.length-1; i++){
            if(key==nums[i]){
                if(map.containsKey(nums[i+1])==false){
                    map.put(nums[i+1], 1);
                }
                else{
                    map.put(nums[i+1],map.get(nums[i+1])+1);
                }
                if(map.get(nums[i+1])>count){
                    count=map.get(nums[i+1]);
                    ans=nums[i+1];
                }
            }
        }
        return ans;
    }
}
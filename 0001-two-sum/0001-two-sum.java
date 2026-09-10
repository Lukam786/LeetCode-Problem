class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            int remainsum=target-curr;
            if(map.containsKey(remainsum)){
                ans[0]=map.get(remainsum);
                ans[1]=i;
                return ans;
            }
            map.put(curr,i);
            
        }
        return ans;
        
    }
}
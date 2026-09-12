class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
       int n=nums.length;
       for(int i=0; i<n; i++){
        if(map.containsKey(nums[i])==false){
             map.put(nums[i],1);
        }
        else{
            map.put(nums[i],map.get(nums[i])+1);
        }
       }
       List<Integer> ans=new ArrayList<>();
       for(int i=0; i<n; i++){
        if(map.containsKey(nums[i]-1)== false &&
         map.containsKey(nums[i]+1)==false && 
         map.get(nums[i])==1){
            ans.add(nums[i]);
         }
       }
       return ans;
    }
}
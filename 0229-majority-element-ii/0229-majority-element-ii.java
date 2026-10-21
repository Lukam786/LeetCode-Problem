class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
        Set<Integer> keySet=map.keySet();
        for(Integer key: keySet){
            if(map.get(key)>n/3){
                arr.add(key);
            }
        
        }
        return arr;
    }
}
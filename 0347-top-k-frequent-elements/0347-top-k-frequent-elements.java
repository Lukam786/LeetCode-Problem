class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }

           PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        List<Integer>list=new ArrayList<>(map.keySet());
        for(int i=0; i<list.size(); i++){
            pq.add(list.get(i));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int result[]=new int[k];
        for(int i=0; i<k; i++){
            result[i]=pq.poll();
        }
        return result;
    }
}
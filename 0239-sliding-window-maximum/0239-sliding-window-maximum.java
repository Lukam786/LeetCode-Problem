class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>queue =new LinkedList<>();
        int[] ans=new int[nums.length-k+1];
        int j=0;
        for(int i=0; i<nums.length; i++){
            while(!queue.isEmpty()&& nums[queue.getLast()]<nums[i]){
                queue.removeLast();

            }
            queue.addLast(i);

            if(queue.getFirst()<=i-k){
                queue.removeFirst();
            }

            if(i>=k-1){
                ans[j++]=nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
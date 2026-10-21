class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
       HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<nums1.length; i++){
             set.add(nums1[i]);
        }
        int count=0;
        int answer[]=new int[2];
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
              count++;
            }
        }
        answer[1]=count;
        set.clear();
        for(int i=0; i<nums2.length; i++){
            set.add(nums2[i]);
        }
        int count1=0;
        for(int i=0; i<nums1.length; i++){
            if(set.contains(nums1[i])){
              count1++;
            }
        }
        answer[0]=count1;
        return answer;
    }
}

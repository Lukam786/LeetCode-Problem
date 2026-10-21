class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        int min = Math.min(nums1.length, nums2.length);
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        int count=0;
        int result[]=new int[min];
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                result[count]=nums2[i];
                count++;
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOf(result,count);
    }
}
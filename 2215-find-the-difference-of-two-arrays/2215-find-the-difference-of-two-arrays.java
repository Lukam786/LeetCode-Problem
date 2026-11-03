class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add nums1 elements
        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        // Add nums2 elements
        for(int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Elements in nums1 but not in nums2
        for(int num : set1) {
            if(!set2.contains(num)) {
                list1.add(num);
            }
        }

        // Elements in nums2 but not in nums1
        for(int num : set2) {
            if(!set1.contains(num)) {
                list2.add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}
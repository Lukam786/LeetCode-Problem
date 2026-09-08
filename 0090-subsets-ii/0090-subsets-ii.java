class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        findSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void findSubsets(int[] nums, int start,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // Current subset ko add karo
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Duplicate ko skip karo
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Recursion
            findSubsets(nums, i + 1, current, result);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
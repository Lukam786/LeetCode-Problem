class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        findSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void findSubsets(int[] nums, int index,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: element lo
        current.add(nums[index]);

        findSubsets(nums, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: element mat lo
        findSubsets(nums, index + 1, current, result);
    }
}
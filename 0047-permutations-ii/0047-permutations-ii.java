class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        findPermutation(nums, used, new ArrayList<>(), result);

        return result;
    }

    public void findPermutation(int[] nums,
                                boolean[] used,
                                List<Integer> current,
                                List<List<Integer>> result) {

        // Base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Har element ko try karo
        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            // Duplicate ko skip karo
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Recursion
            findPermutation(nums, used, current, result);

            // Backtracking
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
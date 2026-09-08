class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        findPermutation(nums, new ArrayList<>(), result);

        return result;
    }

    public void findPermutation(int[] nums,
                                List<Integer> current,
                                List<List<Integer>> result) {

        // Base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop
        for (int i = 0; i < nums.length; i++) {

            // Agar element already use ho chuka hai
            if (current.contains(nums[i])) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Recursion
            findPermutation(nums, current, result);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}

class Solution {

    public int rec(TreeNode curr, HashMap<TreeNode, Integer> dp) {

        if (curr == null) {
            return 0;
        }

        if (dp.containsKey(curr)) {
            return dp.get(curr);
        }

        int notTake = rec(curr.left, dp) + rec(curr.right, dp);

        int take = curr.val;

        if (curr.left != null) {
            take += rec(curr.left.left, dp);
            take += rec(curr.left.right, dp);
        }

        if (curr.right != null) {
            take += rec(curr.right.left, dp);
            take += rec(curr.right.right, dp);
        }

        int ans = Math.max(notTake, take);

        dp.put(curr, ans);

        return ans;
    }

    public int rob(TreeNode root) {

        HashMap<TreeNode, Integer> dp = new HashMap<>();

        return rec(root, dp);
    }
}

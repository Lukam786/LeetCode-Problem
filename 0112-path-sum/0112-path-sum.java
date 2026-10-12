/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();

        return checkPathSum(root, path, targetSum);
    }

    public boolean checkPathSum(TreeNode root, ArrayList<Integer> path,
                                int targetSum) {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            int sum = 0;

            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }

            if (sum == targetSum) {
                return true;
            }
        }

        boolean left = checkPathSum(root.left, path, targetSum);
        boolean right = checkPathSum(root.right, path, targetSum);

        path.remove(path.size() - 1);

        return left || right;
    }
}

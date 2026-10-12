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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        printRoot2Leaf(root, path, targetSum, result);

        return result;
    }

    public void printRoot2Leaf(TreeNode root, ArrayList<Integer> path,
                               int targetSum, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            int sum = 0;

            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }

            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        printRoot2Leaf(root.left, path, targetSum, result);
        printRoot2Leaf(root.right, path, targetSum, result);

        path.remove(path.size() - 1);
    }
}

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
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode rightResult = bstToGst(root.right);

        int data = root.val;
        sum = sum + data;
        root.val = sum;

        TreeNode leftResult = bstToGst(root.left);

        return root;
    }
}

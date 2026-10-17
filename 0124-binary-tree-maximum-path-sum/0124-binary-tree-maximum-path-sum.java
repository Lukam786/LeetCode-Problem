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
    int maxSumPath=Integer.MIN_VALUE;
    public int MaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=Math.max(0,MaxDepth(root.left));
        int rightSum=Math.max(0,MaxDepth(root.right));
        maxSumPath=Math.max(maxSumPath,leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
         MaxDepth(root);
          return maxSumPath;
    }
}
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
    public boolean isValidBST(TreeNode root) {
        return isvalidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    public boolean isvalidBST(TreeNode root, Long minval, Long maxval){
        if(root==null){
            return true;
        }
        if(root.val>=maxval||root.val<=minval){
            return false;
        }
        boolean leftvalid = isvalidBST(root.left, minval, (long)root.val);
        boolean rightvalid= isvalidBST(root.right, (long)root.val, maxval);
        return leftvalid&&rightvalid;
    }
}
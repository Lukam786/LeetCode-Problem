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
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,Long minval,Long  maxval){
        if(root==null){
            return true;
        }
        if(root.val<=minval|| root.val>=maxval){
            return false;
        }
        boolean leftvalid=isValidBST(root.left,minval,(long)root.val);
        boolean rightvalid=isValidBST(root.right,(long)root.val,maxval);
        return leftvalid&&rightvalid;
    }
}
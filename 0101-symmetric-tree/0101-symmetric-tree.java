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
    public static boolean dfs(TreeNode r1, TreeNode r2){
        if(r1==null&&r2==null){
            return true;
        }
        if(r1==null||r2==null){
            return false;
        }
        if(r1.val!=r2.val){
            return false;
        }
        boolean call1=dfs(r1.left,r2.right);
        if(call1==false)return false;
        boolean call2=dfs(r1.right,r2.left);
        return call2;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
        
    }
}
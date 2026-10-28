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
    static int min=Integer.MAX_VALUE;
    static void rec(TreeNode curr,int level){
        if(curr==null){
            return;
        }
        if(curr.left==null && curr.right==null){
            if(level<min){
                min=level;
            }
            return;
        }
    
    rec(curr.left,level+1);
    rec(curr.right,level+1);
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        min=Integer.MAX_VALUE;
        rec(root,1);
        return min;
    }
}
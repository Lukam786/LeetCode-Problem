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
TreeNode prev=null;
int ans=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.left!=null){
            int leftmin=getMinimumDifference(root.left);
             leftmin=Math.min(ans,leftmin);
        }
        if(prev!=null){
            ans=Math.min(ans,root.val-prev.val);
        }
        prev=root;
    
    if(root.right!=null){
        int rightmin=getMinimumDifference(root.right);
        rightmin=Math.min(ans,rightmin);
    }
    return ans;
}
}
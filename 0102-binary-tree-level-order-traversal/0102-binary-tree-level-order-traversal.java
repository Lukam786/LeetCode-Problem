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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(q.size()>0){
          int  count=q.size();
          ArrayList<Integer> ans=new ArrayList<>();
          for(int c=1; c<=count; c++){
            TreeNode lookman=q.remove();
            ans.add(lookman.val);
            if(lookman.left!=null) q.add(lookman.left);
            if(lookman.right!=null)q.add(lookman.right);
          }
          res.add(ans);
        }
        return res;
    }
}
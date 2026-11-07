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
        if(root==null){
            return res;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int count=q.size();
            List<Integer>row=new ArrayList<>();
            for(int c=1; c<=count; c++){
                TreeNode node=q.remove();
                row.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null)q.add(node.right);
                
            }
            res.add(row);
        }
        return res;
    }
}
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
    public void getInOrder(TreeNode root,ArrayList<Integer>inorder1){
        if(root==null){
            return;
        }
        getInOrder(root.left,inorder1);
        inorder1.add(root.val);
        getInOrder(root.right,inorder1);
    }
    public void getInOrder1(TreeNode root,ArrayList<Integer>inorder2)
    {
        if(root==null){
            return;
        }
        getInOrder1(root.left,inorder2);
        inorder2.add(root.val);
        getInOrder1(root.right,inorder2);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer>inorder1=new ArrayList<>();
        ArrayList<Integer> inorder2=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();
        getInOrder(root1,inorder1);
        getInOrder1(root2,inorder2);
        int i=0;
        int j=0;
        while(i<inorder1.size()&& j<inorder2.size()){
            if(inorder1.get(i)<inorder2.get(j)){
                result.add(inorder1.get(i));
                i++;
            }
            else{
                result.add(inorder2.get(j));
                j++;
            }
        }
        while(i<inorder1.size()){
            result.add(inorder1.get(i));
            i++;
        }
        while(j<inorder2.size()){
            result.add(inorder2.get(j));
            j++;
        }
        return result;
    }
}
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
    int idx = 0;

    public int search(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);

        int mid = search(inorder, root.val);

        root.left = dfs(preorder, inorder, l, mid - 1);
        root.right = dfs(preorder, inorder, mid + 1, r);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        TreeNode root = dfs(preorder, inorder, 0, inorder.length - 1);
        return root;
    }
}

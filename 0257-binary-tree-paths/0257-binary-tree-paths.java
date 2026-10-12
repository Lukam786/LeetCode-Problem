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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        printRoot2Leaf(root, path, result);

        return result;
    }

    public void printRoot2Leaf(TreeNode root, ArrayList<Integer> path,
                               List<String> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    str.append("->");
                }
                str.append(path.get(i));
            }

            result.add(str.toString());
        }

        printRoot2Leaf(root.left, path, result);
        printRoot2Leaf(root.right, path, result);

        path.remove(path.size() - 1);
    }
}

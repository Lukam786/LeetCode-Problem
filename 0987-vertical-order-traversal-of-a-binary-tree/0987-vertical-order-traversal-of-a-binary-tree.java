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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] curr = queue.remove();

            TreeNode node = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            pq.add(new int[]{col, row, node.val});

            if (node.left != null) {
                queue.add(new Object[]{node.left, row + 1, col - 1});
            }

            if (node.right != null) {
                queue.add(new Object[]{node.right, row + 1, col + 1});
            }
        }

        int prevCol = Integer.MIN_VALUE;
        List<Integer> column = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();

            int col = curr[0];
            int val = curr[2];

            if (col != prevCol) {
                if (!column.isEmpty()) {
                    ans.add(column);
                }

                column = new ArrayList<>();
                prevCol = col;
            }

            column.add(val);
        }

        if (!column.isEmpty()) {
            ans.add(column);
        }

        return ans;
    }
}

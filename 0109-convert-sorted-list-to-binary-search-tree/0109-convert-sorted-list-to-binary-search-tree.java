/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public ListNode getMid(ListNode head) {
        ListNode prev=null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null){
            prev.next=null;
        }
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mid = getMid(head);
        ListNode righthead = mid.next;
        TreeNode root=new TreeNode(mid.val);
        if(head!=mid){
            root.left=sortedListToBST(head);
        }
        root.right=sortedListToBST(righthead);
        return root;
    }
}
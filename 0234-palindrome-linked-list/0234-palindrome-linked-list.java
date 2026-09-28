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
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>s=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            s.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.val!=s.peek()){
                return false;
            }
            s.pop();
            curr=curr.next;
        }
        return true;
        
    }
}
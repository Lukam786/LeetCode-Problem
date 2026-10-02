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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int len=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
    
        k=k%len;
        if(k==0){
           return head;
        }
            temp.next=head;
        
        ListNode curr=head;
        for(int i=1; i<len-k; i++){
          curr=curr.next;
        }
        ListNode newhead=curr.next;
        curr.next=null;
        return newhead;
    }
}
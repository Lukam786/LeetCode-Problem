/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode findstartingpointofcircle( ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if( slow ==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode temp=headA;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=headB;
        ListNode ans=findstartingpointofcircle(headA);
        temp.next=null;
        return ans;
        
    }
}
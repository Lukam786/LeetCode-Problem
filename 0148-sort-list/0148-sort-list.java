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
    public  ListNode getmiddle(ListNode head){
       if(head==null||head.next==null)
        return head;
        ListNode slow =head; 
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode p1, ListNode p2){
        ListNode head=new ListNode(-1);
       ListNode tail=head;
        while(p1!=null&& p2!=null){
            if(p1.val<=p2.val){
                tail.next=p1;
                p1=p1.next;
                tail=tail.next;
            }
            else{
                tail.next=p2;
                p2=p2.next;
                tail=tail.next;
            }

        }
        if(p1==null)
        tail.next=p2;
        else
        tail.next=p1;
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode mid=getmiddle(head);
        ListNode midnext=mid.next;
        mid.next=null;
        ListNode p1= sortList(head);
        ListNode p2=sortList(midnext);
        return merge(p1,p2);
        
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map=new HashMap<>();
        if(head==null){
            return null;
        }
        Node oldTemp=head;
        Node newhead=new Node(head.val);
         Node newTemp=newhead;
        map.put(head,newhead);
        while(oldTemp.next!=null){
            Node copyNode=new Node(oldTemp.next.val);
            map.put(oldTemp.next,copyNode);
            newTemp.next=copyNode;
            oldTemp=oldTemp.next;
            newTemp=newTemp.next;
        }

        oldTemp=head;
        newTemp=newhead;
        while(oldTemp!=null){
            newTemp.random=map.get(oldTemp.random);
            oldTemp=oldTemp.next;
            newTemp=newTemp.next;
        }
        return newhead;
    }
}

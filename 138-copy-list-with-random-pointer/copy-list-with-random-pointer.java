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
        Node curr = head;
        Node dummy = new Node(0);
        Node tail=dummy;
        Node newHead;

        while (curr != null) {
            Node temp = new Node(curr.val);
            tail.next=temp;
            tail = tail.next;
            curr = curr.next;
        }

        newHead = dummy.next;
        curr = head;
        Node currDummy = newHead;

        while (curr != null) {
            Node randomNode = curr.random;
            Node temp = head;
            Node tempDummy = newHead;
            while (temp != null) {
                if (temp == randomNode) {
                    currDummy.random = tempDummy;
                    break;
                }
                temp = temp.next;
                tempDummy = tempDummy.next;
            }

            curr = curr.next;
            currDummy = currDummy.next;
        }

        return newHead;
    }
}
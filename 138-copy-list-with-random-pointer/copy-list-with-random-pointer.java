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
        Node tail = dummy;
        Node newHead;
        HashMap<Node, Node> map = new HashMap<>();

        while (curr != null) {
            Node temp = new Node(curr.val);
            tail.next = temp;
            map.put(curr, temp);
            tail = tail.next;
            curr = curr.next;
        }

        newHead = dummy.next;
        curr = head;

        while (curr != null) {
            Node randomNode = curr.random;
            map.get(curr).random = map.get(randomNode);
            curr = curr.next;
        }

        return newHead;
    }
}
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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                queue.add(temp.val);
                temp = temp.next;
            }
        }

        while (!queue.isEmpty()) {
            ListNode toAdd = new ListNode(queue.poll());
            dummy.next = toAdd;
            dummy = dummy.next;
        }

        return dummyHead.next;
    }
}
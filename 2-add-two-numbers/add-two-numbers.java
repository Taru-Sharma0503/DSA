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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        int carry = 0, sum = 0;
        ListNode curr = ans;
        while (l1 != null && l2 != null) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10, null);
            curr = curr.next;
        }
        while (l1 != null) {
            sum = carry + l1.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10, null);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = carry + l2.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10, null);
            curr = curr.next;
            l2 = l2.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return ans.next;
    }
}
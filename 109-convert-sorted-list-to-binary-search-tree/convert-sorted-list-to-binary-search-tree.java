class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode middleNode = midNode(head);
        TreeNode root = new TreeNode(middleNode.val);

        if (head == middleNode)
            return root;

        ListNode temp = head;

        while (temp.next != middleNode)
            temp = temp.next;

        temp.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middleNode.next);

        return root;
    }

    public ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
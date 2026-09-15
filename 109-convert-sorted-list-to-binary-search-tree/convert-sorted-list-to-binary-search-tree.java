class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        TreeNode root = null;
        return build(list, 0, list.size() - 1, root);
    }

    public TreeNode build(ArrayList<Integer> list, int low, int high, TreeNode root) {
        if (low > high)
            return root;

        int mid = low + (high - low) / 2;

        root = insert(list.get(mid), root);

        root = build(list, low, mid - 1, root);
        root = build(list, mid + 1, high, root);

        return root;
    }

    public TreeNode insert(int val, TreeNode root) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insert(val, root.left);
        else if (val > root.val)
            root.right = insert(val, root.right);

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
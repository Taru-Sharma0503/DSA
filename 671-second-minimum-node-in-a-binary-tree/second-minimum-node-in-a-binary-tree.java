class Solution {
    long min = Long.MAX_VALUE, secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);   
        if (node.val < min) {
            secondMin = min;
            min = node.val;
        } else if (node.val > min && node.val < secondMin) {
            secondMin = node.val;
        }
        inorder(node.right);
    }
}
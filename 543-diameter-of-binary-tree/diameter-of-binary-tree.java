/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight + rightHeight > diameter)
            diameter = leftHeight + rightHeight;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
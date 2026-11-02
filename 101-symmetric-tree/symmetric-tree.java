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
    public boolean isSymmetric(TreeNode root) {
        return isSymm(root, root);
    }

    public boolean isSymm(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;

        if (leftNode == null || rightNode == null)
            return false;

        return leftNode.val == rightNode.val && isSymm(leftNode.left, rightNode.right)
                && isSymm(leftNode.right, rightNode.left);
    }
}
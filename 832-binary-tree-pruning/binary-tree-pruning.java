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
    public TreeNode pruneTree(TreeNode root) {
        return prune(root) ? root : null;
    }

    public boolean prune(TreeNode root) {
        if (root == null)
            return false;

        boolean hasOneinLeft = prune(root.left);
        boolean hasOneinRight = prune(root.right);

        if (!hasOneinLeft)
            root.left = null;
        if (!hasOneinRight)
            root.right = null;

        if (hasOneinLeft || hasOneinRight || root.val == 1)
            return true;
        else
            return false;
    }
}
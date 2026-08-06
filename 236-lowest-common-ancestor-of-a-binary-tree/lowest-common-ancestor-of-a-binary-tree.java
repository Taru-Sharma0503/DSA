/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p && hasChild(root, q))
            return p;

        if (root == q && hasChild(root, p))
            return q;

        if ((hasChild(root.left, p) || hasChild(root.left, q)) && (hasChild(root.right, p) || hasChild(root.right, q)))
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null)
            return left;
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null)
            return right;
        return null;
    }

    public boolean hasChild(TreeNode root, TreeNode child) {
        if (root == null)
            return false;

        if (root.val == child.val)
            return true;

        return hasChild(root.left, child) || hasChild(root.right, child);
    }
}
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
        if (root == p || root == q)
            return root;
        TreeNode leftContains = lowestCommonAncestor(root.left, p, q);
        TreeNode rightContains = lowestCommonAncestor(root.right, p, q);

        if (leftContains != null && rightContains != null)
            return root;
        if (leftContains != null)
            return leftContains;
        if (rightContains != null)
            return rightContains;
        else
            return null;
    }
}
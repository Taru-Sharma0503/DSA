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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        root=deleteNode(root, target);
        return root;
    }

    public TreeNode deleteNode(TreeNode node, int target) {
        if (node == null)
            return null;

        if (node.val == target && node.left == null && node.right == null) {
            return null;
        }

        node.left = deleteNode(node.left, target);
        node.right = deleteNode(node.right, target);

        if (node.val == target && node.left == null && node.right == null)
            return null;

        return node;
    }
}
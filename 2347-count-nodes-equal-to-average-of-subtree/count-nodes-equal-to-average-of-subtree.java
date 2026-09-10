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
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        countNodes(root, 0);
        return ans;
    }

    public int[] countNodes(TreeNode root, int nodes) {

        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = countNodes(root.left, nodes + 1);
        int sumLeft = left[0];
        int leftNodes = left[1];
        int[] right = countNodes(root.right, nodes + 1);
        int sumRight = right[0];
        int rightNodes = right[1];

        int avg = (root.val + sumLeft + sumRight) / (leftNodes + rightNodes + 1);

        if (avg == root.val)
            ans++;

        return new int[] { (root.val + sumLeft + sumRight), leftNodes + rightNodes + 1 };
    }
}
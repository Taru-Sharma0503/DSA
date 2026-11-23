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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <= inorder.length - 1; i++)
            map.put(inorder[i], i);

        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend || instart > inend)
            return null;

        TreeNode node = new TreeNode(preorder[prestart]);

        int idx = map.get(preorder[prestart]);
        int leftSubtreeSize = idx - instart;

        node.left = buildSubTree(preorder, prestart + 1, prestart + leftSubtreeSize, inorder, instart,
                idx - 1);

        node.right = buildSubTree(preorder, prestart + leftSubtreeSize + 1, preend, inorder, idx + 1, inend);

        return node;
    }
}
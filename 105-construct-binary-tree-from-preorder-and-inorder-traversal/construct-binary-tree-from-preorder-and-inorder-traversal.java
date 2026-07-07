class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubtree(preorder, inorder);
    }

    public TreeNode buildSubtree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);

        if (preorder.length == 1)
            return node;

        int leftSubtreeSize = 0;
        while (inorder[leftSubtreeSize] != node.val)
            leftSubtreeSize++;

        node.left = buildSubtree(
                Arrays.copyOfRange(preorder, 1, leftSubtreeSize + 1),
                Arrays.copyOfRange(inorder, 0, leftSubtreeSize));

        node.right = buildSubtree(
                Arrays.copyOfRange(preorder, leftSubtreeSize + 1, preorder.length),
                Arrays.copyOfRange(inorder, leftSubtreeSize + 1, inorder.length));

        return node;
    }
}
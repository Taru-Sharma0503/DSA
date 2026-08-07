class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildSubtree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubtree(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd)
            return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int idx = map.get(node.val);

        int leftSubtreeSize = idx - inStart;

        node.left = buildSubtree(
                preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, idx - 1);

        node.right = buildSubtree(
                preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, idx + 1, inEnd);

        return node;
    }
}
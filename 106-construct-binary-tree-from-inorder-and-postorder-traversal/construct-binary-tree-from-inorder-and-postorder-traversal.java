class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int idx = findIdx(root.val, inorder);

        int leftSize = idx - inStart;

        root.left = buildTree(
                inorder, inStart, idx - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = buildTree(
                inorder, idx + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    public int findIdx(int val, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
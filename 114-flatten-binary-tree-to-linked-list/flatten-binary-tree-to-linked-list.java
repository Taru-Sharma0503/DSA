class Solution {

    TreeNode dummy = null;

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public void flattenTree(TreeNode root) {
        if (root == null)
            return;

        flattenTree(root.right);
        flattenTree(root.left);

        root.right = dummy;
        root.left = null;
        dummy = root;
    }
}
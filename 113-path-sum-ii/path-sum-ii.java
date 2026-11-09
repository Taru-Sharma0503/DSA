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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return ans;
        List<Integer> list = new ArrayList<>();

        findTarget(root, list, 0, targetSum);
        return ans;
    }

    public void findTarget(TreeNode node, List<Integer> list, int sum, int target) {
        if (node == null)
            return;
        list.add(node.val);
        sum+=node.val;
        if (node.left == null && node.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        findTarget(node.left, list, sum, target);
        findTarget(node.right, list, sum, target);
        list.remove(list.size()-1);
    }
}
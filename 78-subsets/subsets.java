class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void backtrack(int idx, int[] nums, List<Integer> temp) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backtrack(idx + 1, nums, temp);
        temp.remove(temp.size() - 1);
        backtrack(idx + 1, nums, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }
}
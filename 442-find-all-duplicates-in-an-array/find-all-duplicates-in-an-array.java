class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num))
                ans.add(num);
            else
                set.add(num);
        }

        return ans;
    }
}
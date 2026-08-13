class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i]))
                continue;

            if (map.containsKey(nums[i] + 1)) {
                int len = map.get(nums[i]) + map.get(nums[i] + 1);
                ans = Math.max(ans, len);
                set.add(nums[i]);
            }
        }

        return ans;
    }
}
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length, s = 0, e = 0, ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (e < n) {
            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);

            if (map.get(nums[e]) <= k) {
                e++;
            } else {
                ans = Math.max(ans, e - s);
                while (map.get(nums[e]) > k) {
                    if (s < n)
                        map.put(nums[s], map.get(nums[s]) - 1);
                    s++;
                }
                e++;
            }
        }
        ans = Math.max(ans, e - s);

        return ans;
    }
}
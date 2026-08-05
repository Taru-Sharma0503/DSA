class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int n = nums.length;
        int s = 0, e = 0, diff = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (e < n) {

            if (!map.containsKey(nums[e]))
                diff++;

            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);

            while (diff > k) {
                map.put(nums[s], map.get(nums[s]) - 1);

                if (map.get(nums[s]) == 0) {
                    map.remove(nums[s]);
                    diff--;
                }

                s++;
            }

            ans += (e - s + 1);
            e++;
        }

        return ans;
    }
}
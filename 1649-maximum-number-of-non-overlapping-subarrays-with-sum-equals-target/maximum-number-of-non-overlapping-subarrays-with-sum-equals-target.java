class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length, ans = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - target)) {
                ans++;
                prefixSum = 0;
                map.clear();
                map.put(0, 1);
            } else
                map.put(prefixSum, 1);
        }

        return ans;
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0;
        long ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > 1) {
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            if (right - left + 1 > k) {
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            if (right - left + 1 == k)
                ans = Math.max(ans, sum);
            right++;
        }

        return ans;
    }
}
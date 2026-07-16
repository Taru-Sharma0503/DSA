class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length, right = 0, left = 0;
        long sum = 0, ans = 0;

        while (right < n) {
            sum += nums[right];

            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}
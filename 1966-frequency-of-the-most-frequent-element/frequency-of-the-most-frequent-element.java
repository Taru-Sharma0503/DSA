class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = 1, ans = 1;
        if (n == 1)
            return 1;

        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i];

        while (right < n) {
            long windowSize = right - left + 1;
            long requiredSum = nums[right] * windowSize;
            long windowSum = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
            long operations = requiredSum - windowSum;
            if (operations <= k) {
                ans = Math.max(ans, (int) windowSize);
            } else
                left++;
            right++;
        }

        return ans;
    }
}
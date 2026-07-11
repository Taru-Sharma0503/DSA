class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, maxSum = nums[0], prefixSum = nums[0], currMax = nums[0];
        int suffix[] = new int[n];
        int rightMax[] = new int[n];
        suffix[n - 1] = nums[n - 1];
        rightMax[n - 1] = suffix[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i + 1];
            rightMax[i] = Math.max(suffix[i], rightMax[i + 1]);
        }

        if (n > 1)
            maxSum = Math.max(maxSum, prefixSum + rightMax[1]);
        
        for (int i = 1; i < n; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
            prefixSum += nums[i];
            if (i + 1 < n) {
                maxSum = Math.max(maxSum, prefixSum + rightMax[i + 1]);
            }
        }

        return maxSum;
    }
}
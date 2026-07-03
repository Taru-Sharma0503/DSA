class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, currSum = 0, maxSum = Integer.MIN_VALUE, left = 0, right = 0;

        while (right < n) {
            currSum += nums[right];
            if (right - left + 1 > k) {
                currSum -= nums[left];
                left++;
            } 
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currSum);
            }
            right++;
        }

        return (double) maxSum / k;
    }
}
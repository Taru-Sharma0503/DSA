class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, sum = nums[n - 1];
        int rightSum[] = new int[n];

        rightSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for (int i = 0; i < n ; i++) {
            if (sum == rightSum[i])
                return i;

            sum += nums[i];
        }

        return -1;
    }
}
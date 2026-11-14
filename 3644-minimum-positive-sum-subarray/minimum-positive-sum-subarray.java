class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), ans = Integer.MAX_VALUE;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums.get(0);
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + nums.get(i);

        for (int i = 0; i < n; i++) {
            for (int j = l; j <= r; j++) {
                int k = i + j - 1;
                if (k >= n)
                    break;
                int sum = i == 0 ? prefixSum[k] : prefixSum[k] - prefixSum[i - 1];
                if (sum > 0)
                    ans = Math.min(ans, sum);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
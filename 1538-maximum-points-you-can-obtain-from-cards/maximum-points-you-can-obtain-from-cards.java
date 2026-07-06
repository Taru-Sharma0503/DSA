class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = cardPoints[0], left = 0, right = 0, ans = Integer.MIN_VALUE;
        int prefixSum[] = new int[n];

        prefixSum[0] = cardPoints[0];
        for (int i = 1; i < n; i++) {
            sum += cardPoints[i];
            prefixSum[i] = prefixSum[i - 1] + cardPoints[i];
        }

        while (right < n) {
            int windowSize = right - left + 1;
            int currWindowSum = left > 0 ? prefixSum[right] - prefixSum[left - 1] : prefixSum[right];
            if (windowSize > n - k) {
                left++;
            } else if (windowSize == n - k) {
                ans = Math.max(ans, sum - currWindowSum);
                right++;
            } else {
                right++;
            }
        }

        return ans;
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0, left = 0, right = 0;
        int ans = Integer.MIN_VALUE, currWindowSum = 0;

        for (int num : cardPoints)
            sum += num;

        if (k == n)
            return sum;

        while (right < n) {
            currWindowSum += cardPoints[right];

            if (right - left + 1 > n - k) {
                currWindowSum -= cardPoints[left];
                left++;
            }

            if (right - left + 1 == n - k) {
                ans = Math.max(ans, sum - currWindowSum);
            }

            right++;
        }

        return ans;
    }
}
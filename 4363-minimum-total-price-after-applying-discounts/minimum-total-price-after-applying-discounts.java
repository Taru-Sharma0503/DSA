class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double ans = 0.0;
        int idx=discounts.length-1;

        Arrays.sort(prices);
        Arrays.sort(discounts);

        for (int i = prices.length-1; i >= 0; i--) {
            if (idx >= 0)
                ans += (double)(prices[i] * (100 - discounts[idx--])) / 100.0;
            else
                ans += prices[i];
        }

        return ans;
    }
}
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, ans = 0, j;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
                j = i;
                while (j > 0 && ratings[j] < ratings[j - 1] && candies[j] >= candies[j - 1]) {
                    candies[j - 1] = candies[j] + 1;
                    j--;
                }
            }
        }

        for (int candy : candies)
            ans += candy;

        return ans;
    }
}
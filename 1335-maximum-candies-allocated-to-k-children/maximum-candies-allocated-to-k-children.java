class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length, max = Integer.MIN_VALUE, ans = 0;
        long validCount = 0, sum = 0;

        for (int candy : candies) {
            if (candy > max)
                max = candy;
            sum += candy;
        }

        if (sum < (int) k)
            return 0;

        int s = 1, e = max;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            validCount = countValid(mid, candies);
            if (validCount >= k) {
                ans = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }

        return ans;
    }

    public long countValid(int num, int[] arr) {
        long valid = 0;

        for (int element : arr) {
            valid += element / num;
        }

        return valid;
    }
}
class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            if (digit > max) {
                secondMax = max;
                max = digit;
            } else if (digit > secondMax)
                secondMax = digit;
        }

        return max * secondMax;
    }
}
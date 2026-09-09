class Solution {
    public long countCommas(long n) {
        long ans = 0, temp = n, commas;
        long length = calculateLength(temp);

        for (long i = 4; i <= length; i++) {
            commas = (i - 1) / 3;

            if (i == length) {
                ans += (n - Math.pow(10, i - 1) + 1) * commas;
            } else {
                ans += (Math.pow(10, i) - 1 - Math.pow(10, i - 1) + 1) * commas;
            }
        }

        return ans;
    }

    public long calculateLength(long n) {
        long len = 0;

        while (n > 0) {
            n = n / 10;
            len++;
        }

        return len;
    }
}
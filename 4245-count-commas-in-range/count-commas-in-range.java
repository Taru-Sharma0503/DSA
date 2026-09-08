class Solution {
    public int countCommas(int n) {
        int ans = 0, temp = n, commas;
        int length = calculateLength(temp);

        for (int i = 4; i <= length; i++) {
            commas = (i - 1) / 3;

            if (i == length) {
                ans += (n - Math.pow(10, i - 1) + 1) * commas;
            } else {
                ans += (Math.pow(10, i) - 1 - Math.pow(10, i - 1) + 1) * commas;
            }
        }

        return ans;
    }

    public int calculateLength(int n) {
        int len = 0;

        while (n > 0) {
            n = n / 10;
            len++;
        }

        return len;
    }
}
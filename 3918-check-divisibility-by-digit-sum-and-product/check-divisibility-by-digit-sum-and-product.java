class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0, pdt = 1;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            sum += digit;
            pdt *= digit;
        }

        return n % (sum + pdt) == 0;
    }
}
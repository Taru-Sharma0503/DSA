class Solution {
    public int trailingZeroes(int n) {
        int power = 1, count = 0, divideBy = 5;

        while (n >= divideBy) {
            count += n / divideBy;
            power++;
            divideBy = (int) Math.pow(5, power);
        }

        return count;
    }
}
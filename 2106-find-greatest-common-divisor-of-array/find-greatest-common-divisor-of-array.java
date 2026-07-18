class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        return gcd(min, max);
    }

    public int gcd(int a, int b) {
        if (b % a == 0)
            return a;
        else
            return gcd(b % a, a);
    }
}
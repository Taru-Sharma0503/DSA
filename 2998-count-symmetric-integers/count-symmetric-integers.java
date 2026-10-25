class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int num = low; num <= high; num++) {
            if (isSymmetric(num))
                ans++;
        }

        return ans;
    }

    public boolean isSymmetric(int num) {
        int getLen = calcLength(num);
        int len = getLen / 2, count = 0;
        if (getLen % 2 != 0)
            return false;
        int sum1 = 0, sum2 = 0;

        while (num > 0) {
            int digit = num % 10;
            if (count < len) {
                sum2 += digit;
                count++;
            } else {
                sum1 += digit;
            }
            num /= 10;
        }

        return sum1 == sum2;
    }

    public int calcLength(int num) {
        int len = 0;

        while (num > 0) {
            num /= 10;
            len++;
        }

        return len;
    }
}
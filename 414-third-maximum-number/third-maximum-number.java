class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        boolean hasSecond = false, hasThird = false;

        for (int num : nums)
            max = Math.max(max, num);

        for (int num : nums) {
            if (num == max)
                continue;

            if (!hasSecond || num > secondMax) {
                if (hasSecond && num == secondMax)
                    continue;

                thirdMax = secondMax;
                hasThird = hasSecond;

                secondMax = num;
                hasSecond = true;
            } else if (num != secondMax && (!hasThird || num > thirdMax)) {
                thirdMax = num;
                hasThird = true;
            }
        }

        return hasThird ? thirdMax : max;
    }
}
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0, l = -1, r = -1;
        boolean needEven = true;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if ((num > threshold) || (needEven && num % 2 != 0) || (!needEven && num % 2 == 0)) {
                if (l == -1 && r == -1) {
                    needEven = true;
                    continue;
                }

                ans = Math.max(ans, r - l + 1);

                if (num % 2 == 0 && num <= threshold) {
                    l = r = i;
                    needEven = false;
                } else {
                    l = r = -1;
                    needEven = true;
                }
            }

            else if (needEven) {
                if (l == -1 && r == -1) {
                    l = i;
                    r = i;
                } else
                    r = i;
                needEven = false;
            }

            else {
                r = i;
                needEven = true;
            }
        }

        if (l != -1)
            ans = Math.max(ans, r - l + 1);
        return ans;
    }
}
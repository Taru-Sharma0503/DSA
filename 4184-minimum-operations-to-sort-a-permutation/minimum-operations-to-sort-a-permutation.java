class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean forward = true, backward = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n)
                forward = false;

            if (nums[i] != (nums[0] - i + n) % n)
                backward = false;
        }

        if (forward) {
            int k = nums[0];
            if (k == 0)
                return 0;
            return Math.min(n - k, k + 2);
        }

        if (backward) {
            int k = (n - 1 - nums[0] + n) % n;
            return Math.min(k + 1, n - k + 1);
        }

        return -1;
    }
}
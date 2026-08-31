class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, bad = -1, good = -1, ans = 0;

        for (int e = 0; e < n; e++) {
            if (nums[e] > right)
                bad = e;

            if (nums[e] >= left)
                good = e;

            ans += good - bad;
        }

        return ans;
    }
}
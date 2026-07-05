class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, ans = 0, left = 0, right = 0, deletedPos = -1;

        while (right < n) {
            if (nums[right] == 1)
                right++;
            else {
                if (deletedPos == -1) {
                    deletedPos = right;
                    right++;
                } else {
                    ans = Math.max(ans, right - left - 1);
                    left = deletedPos + 1;
                    deletedPos = right;
                    right++;
                }
            }
        }
        ans = Math.max(right - left - 1, ans);

        return ans;
    }
}
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = -nums[i];
        }

        Arrays.sort(nums);
        long num = 1, ans = 0;
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            if (s == e)
                ans += nums[s] * nums[s];
            else {
                ans += nums[e] * nums[e];
                ans -= nums[s] * nums[s];
            }

            s++;
            e--;
        }

        return ans;
    }
}
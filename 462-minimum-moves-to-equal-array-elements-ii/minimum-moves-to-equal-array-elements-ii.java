class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, target;
        if (n % 2 != 0) {
            target = nums[n / 2];
        } else {
            target = (nums[n / 2] + nums[(n / 2) - 1]) / 2;
        }

        int ans = 0;
        for (int num : nums)
            ans += Math.abs(target - num);

        return ans;
    }
}
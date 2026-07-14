class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, count1 = 0, count0 = 0, right = 0, left = 0, ans = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == 1)
                count1++;
        }

        if (count1 == 0)
            return 0;

        while (right < 2 * n) {
            if (nums[right % n] == 0)
                count0++;

            if (right - left + 1 == count1) {
                ans = Math.min(ans, count0);
                if (nums[left % n] == 0)
                    count0--;
                left++;
                ;
            }

            right++;
        }

        return ans;
    }
}
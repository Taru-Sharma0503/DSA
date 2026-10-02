class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, idx = -1, freq = 1;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                freq++;
            else
                freq = 1;

            if (freq > 3)
                continue;
            if (freq < 3)
                nums[++idx] = nums[i];
        }

        return idx + 1;
    }
}
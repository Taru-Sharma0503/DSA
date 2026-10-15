class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
            if (i == 0 && nums[i + 1] != nums[i])
                return nums[i];
            if (i != 0 && nums[i] != nums[i - 1])
                return nums[i];
        }

        return -1;
    }
}
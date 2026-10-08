class Solution {
    public boolean isMonotonic(int[] nums) {
        int increasing = 2;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            else if (nums[i] < nums[i + 1]) {
                if (increasing == 2)
                    increasing = 1;
                else if (increasing == 0)
                    return false;
            } else {
                if (increasing == 2)
                    increasing = 0;
                else if (increasing == 1)
                    return false;
            }
        }

        return true;
    }
}
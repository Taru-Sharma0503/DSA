class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length, sum = nums[0], idx = 1;
        HashSet<Integer> set = new HashSet<>();

        set.add(nums[0]);
        while (idx < n) {
            set.add(nums[idx]);

            if (nums[idx] == nums[idx - 1] + 1)
                sum += nums[idx++];
            else {
                break;
            }
        }
        
        while (idx < n)
            set.add(nums[idx++]);

        for (int i = sum; ; i++) {
            if (!set.contains(i))
                return i;
        }
    }
}
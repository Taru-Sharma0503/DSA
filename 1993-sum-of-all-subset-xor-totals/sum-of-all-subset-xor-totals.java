class Solution {
    public int subsetXORSum(int[] nums) {
        return calculate(nums, 0, 0);
    }

    private int calculate(int[] nums, int index, int currentXOR) {
        if(index == nums.length) return currentXOR;

        int include = calculate(nums, index+1, nums[index] ^ currentXOR);
        int exclude = calculate(nums, index+1, currentXOR);
        return include + exclude;
    }
}
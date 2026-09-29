class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (count1 == 0 && nums[i] != candidate2) {
                candidate1 = nums[i];
            }

            if (count2 == 0 && nums[i] != candidate1) {
                candidate2 = nums[i];
            }

            if (nums[i] == candidate1)
                count1++;
            else if (nums[i] == candidate2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }

        int actualCount1 = 0, actualCount2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                actualCount1++;

            if (num == candidate2)
                actualCount2++;
        }

        if (actualCount1 > nums.length / 3)
            ans.add(candidate1);

        if (actualCount2 > nums.length / 3 && candidate2 != candidate1)
            ans.add(candidate2);

        return ans;
    }
}
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, balance = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                balance--;
            else
                balance++;
            if (map.containsKey(balance)) {
                ans = Math.max(ans, i - map.get(balance));
                continue;
            }
            map.put(balance, i);
        }

        return ans;
    }
}
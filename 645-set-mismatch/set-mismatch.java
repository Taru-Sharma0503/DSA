class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, duplicate = 0;
        int freq[] = new int[10001];
        int ans[] = new int[2];

        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 2)
                ans[0] = num;
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}
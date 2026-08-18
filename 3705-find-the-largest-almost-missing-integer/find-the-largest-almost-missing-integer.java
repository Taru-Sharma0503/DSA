class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length, ans = -1;
        int freq[] = new int[51];
        HashSet<Integer> set;

        for (int i = 0; i <= n - k; i++) {
            set=new HashSet<>();
            for (int j = i; j < i + k; j++) {
                if(!set.contains(nums[j]))
                    freq[nums[j]]++;
                set.add(nums[j]);
            }
        }

        for (int i = 0; i < 51; i++) {
            if (freq[i] == 1)
                ans = i;
        }

        return ans;
    }
}
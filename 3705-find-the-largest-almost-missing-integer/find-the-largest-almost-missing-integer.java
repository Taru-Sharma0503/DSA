class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
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

        for (int i = 50; i >=0; i--) {
            if (freq[i] == 1)
                return i;
        }

        return -1;
    }
}
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int freq[] = new int[101];
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            count = 0;
            Arrays.fill(freq, 0);
            for (int j = i; j < nums.size(); j++) {
                int ele = nums.get(j);
                freq[ele]++;
                if (freq[ele] == 1)
                    count++;
                ans += count * count;
            }
        }

        return ans;
    }
}
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums2) {
            freq.put(num * k, freq.getOrDefault(num * k, 0) + 1);
        }
        
        for (int num : nums1) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    ans += freq.getOrDefault(i, 0);
                    if (i != num / i) {
                        ans += freq.getOrDefault(num / i, 0);
                    }
                }
            }
        }
        return ans;
    }
}
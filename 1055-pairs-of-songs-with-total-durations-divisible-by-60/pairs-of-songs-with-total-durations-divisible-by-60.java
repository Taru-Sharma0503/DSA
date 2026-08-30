class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int r = time[i] % 60;
            ans += map.getOrDefault((60 - r) % 60, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        return ans;
    }
}
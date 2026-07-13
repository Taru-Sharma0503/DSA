class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length(), idx = 0, start = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            idx = Math.max(idx, s.lastIndexOf(ch));

            if (idx == i) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}
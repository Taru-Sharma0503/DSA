class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int idx = k - 1;

        while (idx >= 0)
            ans.append(s.charAt(idx--));

        idx = k;
        while (idx < s.length())
            ans.append(s.charAt(idx++));

        return ans.toString();
    }
}
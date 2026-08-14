class Solution {
    public int maximumLengthSubstring(String s) {
        int len = s.length(), ans = 1, st = 0, e = 0;
        int freq[] = new int[26];
        char ch;

        while (e < len) {
            ch = s.charAt(e);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 2) {
                freq[s.charAt(st) - 'a']--;
                st++;
            }

            ans = Math.max(ans, e - st + 1);
            e++;
        }

        return ans;
    }
}
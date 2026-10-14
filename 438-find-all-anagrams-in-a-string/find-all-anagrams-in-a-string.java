class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int freqp[] = new int[26];

        for (char ch : p.toCharArray())
            freqp[ch - 'a']++;

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (areAnagrams(s.substring(i, i + p.length()), freqp))
                ans.add(i);
        }

        return ans;
    }

    public boolean areAnagrams(String s, int[] freqp) {
        int[] freqs = new int[26];
        for (char ch : s.toCharArray())
            freqs[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (freqs[i] != freqp[i])
                return false;
        }

        return true;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        int oddFreq = 0, evenFreq = 0, freq;
        int upper[] = new int[26];
        int lower[] = new int[26];

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A']++;
            }

            else {
                lower[ch - 'a']++;
            }
        }

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                freq = upper[ch - 'A'];
                if (freq == -1)
                    continue;
                if (freq % 2 == 0)
                    evenFreq += freq;
                else {
                    evenFreq += freq - 1;
                    oddFreq = 1;
                }
                upper[ch - 'A'] = -1;
            }

            else {
                freq = lower[ch - 'a'];
                if (freq == -1)
                    continue;
                if (freq % 2 == 0)
                    evenFreq += freq;
                else {
                    evenFreq += freq - 1;
                    oddFreq = 1;
                }
                lower[ch - 'a'] = -1;
            }
        }

        return evenFreq + oddFreq;
    }
}
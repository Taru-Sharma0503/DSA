class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int freq[] = new int[26];
        int check[] = new int[26];

        for (char c : s1.toCharArray())
            freq[c - 'a']++;

        int left = 0, right = 0;

        while (right < len2) {
            check[s2.charAt(right) - 'a']++;
            if (right - left + 1 == len1) {
                if (Arrays.equals(freq, check))
                    return true;
                check[s2.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return false;
    }
}
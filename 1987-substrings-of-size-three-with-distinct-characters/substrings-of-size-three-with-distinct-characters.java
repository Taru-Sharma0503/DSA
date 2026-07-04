class Solution {
    public int countGoodSubstrings(String s) {
        int len = s.length(), left = 0, right = 0, ans = 0;
        for (int i = 0; i <= len - 3; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            char ch3 = s.charAt(i + 2);
            if (isGood(ch1, ch2, ch3))
                ans++;
        }

        return ans;
    }

    public boolean isGood(char ch1, char ch2, char ch3) {
        return ch1 != ch2 && ch1 != ch3 && ch2 != ch3;
    }
}
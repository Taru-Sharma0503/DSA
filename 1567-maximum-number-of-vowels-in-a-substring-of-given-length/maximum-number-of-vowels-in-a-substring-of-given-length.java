class Solution {
    public int maxVowels(String s, int k) {
        int len = s.length(), left = 0, right = 0, vowelCount = 0, maxVowel = 0;
        while (right < len) {
            char ch = s.charAt(right);

            if (isVowel(ch))
                vowelCount++;

            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                if (isVowel(leftChar))
                    vowelCount--;
                left++;
            }
            maxVowel = Math.max(maxVowel, vowelCount);
            right++;
        }

        return maxVowel;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
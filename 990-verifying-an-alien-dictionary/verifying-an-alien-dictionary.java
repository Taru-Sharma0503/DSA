class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length, idx = 0;

        for (int i = 0; i < len - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];

            idx = 0;
            while (idx < firstWord.length() && idx < secondWord.length()
                    && firstWord.charAt(idx) == secondWord.charAt(idx))
                idx++;

            if (idx == firstWord.length())
                continue;

            if (idx == secondWord.length())
                return false;

            char ch1 = firstWord.charAt(idx);
            char ch2 = secondWord.charAt(idx);

            for (char letter : order.toCharArray()) {
                if (letter == ch2)
                    return false;

                if (letter == ch1)
                    break;
            }
        }

        return true;
    }
}
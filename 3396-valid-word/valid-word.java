class Solution {
    public boolean isValid(String word) {
        int len = word.length();
        if (len < 3)
            return false;
        int vowels = 0, constants = 0;

        for (char ch : word.toCharArray()) {
            if (!Character.isDigit(ch) && !Character.isLetter(ch))
                return false;

            if(Character.isDigit(ch))
                continue;
            else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'U'
                    || ch == 'I' || ch == 'O')
                vowels++;
            else
                constants++;
        }

        return vowels > 0 && constants > 0 ? true : false;
    }
}
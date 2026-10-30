class Solution {
    public String getSmallestString(String s) {
        StringBuilder ans = new StringBuilder();
        boolean isSwapped = false;

        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            if (haveSameParity(ch1, ch2) && !isSwapped && (ch2 - '0' < ch1 - '0')) {
                ans.append(ch2);
                ans.append(ch1);
                isSwapped = true;
                i++;
            } else {
                ans.append(ch1);
            }
        }
        if(ans.length()!=s.length())
            ans.append(s.charAt(s.length() - 1));

        return ans.toString();
    }

    public boolean haveSameParity(char ch1, char ch2) {
        int num1 = ch1 - '0';
        int num2 = ch2 - '0';

        return (num1 % 2 != 0 && num2 % 2 != 0) || (num1 % 2 == 0 && num2 % 2 == 0);
    }
}
class Solution {
    public String makeFancyString(String s) {
        if(s.length()==1)
            return s;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch != s.charAt(i + 1)) {
                ans.append(ch);
            } else {
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                ans.append(ch).append(ch);
            }
        }

        if (s.charAt(s.length() - 1) != s.charAt(s.length() - 2))
            ans.append(s.charAt(s.length() - 1));
        return ans.toString();
    }
}
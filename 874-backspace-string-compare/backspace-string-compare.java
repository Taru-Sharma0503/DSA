class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (str1.length() == 0)
                    continue;
                str1.setLength(str1.length() - 1);
            } else {
                str1.append(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (str2.length() == 0)
                    continue;
                str2.setLength(str2.length() - 1);
            } else {
                str2.append(ch);
            }
        }

        return str1.toString().equals(str2.toString());
    }
}
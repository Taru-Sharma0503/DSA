class Solution {
    public boolean checkValidString(String s) {
        int len = s.length(), low = 0, high = 0, i;
        char ch;
        for (i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }
            if (low < 0)
                low = 0;
            if (high < 0)
                return false;
        }
        return low == 0;
    }
}
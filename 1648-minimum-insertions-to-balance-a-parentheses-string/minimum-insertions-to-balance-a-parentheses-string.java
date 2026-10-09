class Solution {
    public int minInsertions(String s) {
        int open = 0, close = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (close == 1) {
                    ans++;
                    if (open > 0)
                        open--;
                    else
                        ans++;
                    close = 0;
                }
                open++;
            } else {
                close++;
                if (close == 2) {
                    if (open > 0)
                        open--;
                    else
                        ans++;
                    close = 0;
                }
            }
        }

        if (close == 1) {
            ans++;
            if (open > 0)
                open--;
            else
                ans++;
        }
        return ans + open * 2;
    }
}
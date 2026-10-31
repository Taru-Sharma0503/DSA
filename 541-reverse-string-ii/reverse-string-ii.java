class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        boolean reverse = true;
        int idx = 0, len = s.length();

        while (idx < len) {
            if (reverse) {
                String reversed = reverse(s, idx, idx + k - 1);
                ans.append(reversed);
            } else {
                String notReversed = noreverse(s, idx, idx + k - 1);
                ans.append(notReversed);
            }
            reverse = !reverse;
            idx = idx + k;
        }

        return ans.toString();
    }

    public String reverse(String s, int i, int j) {
        if (j >= s.length())
            j = s.length() - 1;

        StringBuilder reversed = new StringBuilder();

        for (int idx = j; idx >= i; idx--)
            reversed.append(s.charAt(idx));

        return reversed.toString();
    }

    public String noreverse(String s, int i, int j) {
        StringBuilder notreversed = new StringBuilder();

        for (int idx = i; idx <= j && idx < s.length(); idx++)
            notreversed.append(s.charAt(idx));

        return notreversed.toString();
    }
}
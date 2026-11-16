class Solution {
    public String digitSum(String s, int k) {
        int len = s.length(), idx = 0, sum = 0;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder temp = new StringBuilder();
        StringBuilder next = new StringBuilder();

        while (sb.length() > k) {
            if (idx < sb.length()) {
                temp.append(sb.charAt(idx));
                sum += sb.charAt(idx) - '0';
            }

            idx++;

            if (temp.length() == k || idx == sb.length()) {
                next.append(sum);
                temp = new StringBuilder();
                sum = 0;
            }

            if (idx == sb.length()) {
                sb = next;
                next = new StringBuilder();
                idx = 0;
            }
        }

        return sb.toString();
    }
}
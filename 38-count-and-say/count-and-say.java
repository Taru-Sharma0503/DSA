class Solution {
    public String countAndSay(int n) {
        return countSay(new StringBuilder(), 1, n);
    }

    public String countSay(StringBuilder ans, int count, int n) {
        if (count == 1) {
            ans.append("1");
            if (n == 1)
                return ans.toString();
            return countSay(ans, count + 1, n);
        }

        else {
            int counter = 1;
            int idx = 0, size = ans.length();
            StringBuilder temp = new StringBuilder();
            while (idx < size) {
                counter = 1;
                while (idx < size - 1 && ans.charAt(idx + 1) == ans.charAt(idx)) {
                    counter++;
                    idx++;
                }

                temp.append(counter).append(ans.charAt(idx));
                idx++;
            }

            ans = temp;
            if (count == n)
                return ans.toString();
            return countSay(ans, count + 1, n);
        }
    }
}
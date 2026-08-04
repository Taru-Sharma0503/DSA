class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(num, target, new StringBuilder(), 0, 0, 0);
        return ans;
    }

    public void dfs(String num, int target, StringBuilder exp,
                    long curr, long last, int index) {

        if (index == num.length()) {
            if (curr == target)
                ans.add(exp.toString());
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0')
                break;

            String operand = num.substring(index, i + 1);
            long digit = Long.parseLong(operand);

            int len = exp.length();

            if (index == 0) {

                exp.append(operand);
                dfs(num, target, exp, digit, digit, i + 1);
                exp.setLength(len);

            } else {

                exp.append("+").append(operand);
                dfs(num, target, exp,
                        curr + digit,
                        digit,
                        i + 1);
                exp.setLength(len);

                exp.append("-").append(operand);
                dfs(num, target, exp,
                        curr - digit,
                        -digit,
                        i + 1);
                exp.setLength(len);

                exp.append("*").append(operand);
                dfs(num, target, exp,
                        curr - last + last * digit,
                        last * digit,
                        i + 1);
                exp.setLength(len);
            }
        }
    }
}
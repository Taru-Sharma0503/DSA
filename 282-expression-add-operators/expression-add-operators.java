class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(num, target, "", 0, 0, 0);
        return ans;
    }

    public void dfs(String num, int target, String exp, long curr, long last, int index) {

        if (index == num.length()) {
            if (curr == target)
                ans.add(exp);
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0')
                break;

            long digit = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                dfs(num, target,
                        exp + digit,
                        digit,
                        digit,
                        i + 1);
            } else {
                dfs(num, target,
                        exp + "+" + digit,
                        curr + digit,
                        digit,
                        i + 1);

                dfs(num, target,
                        exp + "-" + digit,
                        curr - digit,
                        -digit,
                        i + 1);

                dfs(num, target,
                        exp + "*" + digit,
                        curr - last + last * digit,
                        last * digit,
                        i + 1);
            }
        }
    }
}
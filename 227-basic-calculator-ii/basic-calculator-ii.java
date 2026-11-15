class Solution {
    public int calculate(String s) {

        int res = 0;
        int curr = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        boolean multiply = false, divide = false;

        for (char c : s.toCharArray()) {
            if (c == ' ')
                continue;
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } else if (multiply || divide) {
                int num = stack.pop();

                if (multiply)
                    stack.push(num * curr);
                else
                    stack.push(num / curr);

                multiply = false;
                divide = false;
                curr = 0;

                if (c == '*' || c == '/') {
                    multiply = c == '*';
                    divide = c == '/';
                    continue;
                }

                if (c == '+')
                    sign = 1;
                else
                    sign = -1;

                continue;
            }
            if (c == '+') {
                stack.push(curr * sign);
                sign = 1;
                curr = 0;
            } else if (c == '-') {
                stack.push(curr * sign);
                sign = -1;
                curr = 0;
            } else if (c == '/' || c == '*') {
                stack.push(curr * sign);
                sign = 1;
                if (c == '/')
                    divide = true;
                if (c == '*')
                    multiply = true;
                curr = 0;
            }
        }

        if (multiply || divide) {
            int num = stack.pop();
            if (multiply) {
                stack.push(num * curr);
                multiply = false;
            } else {
                stack.push(num / curr);
                divide = false;
            }
        } else
            stack.push(curr * sign);

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
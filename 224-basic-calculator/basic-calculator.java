class Solution {
    public int calculate(String s) {
        int ans = 0, len = s.length(), num = 0;
        char operation = '#';
        Stack<Character> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ' ')
                continue;

            if (ch == ')') {
                stack.push(ch);
            }
            else if (ch == '(') {
                int result = 0;
                num = 0;
                char op = '#';

                char character = stack.pop();

                while (character != ')') {

                    if (Character.isDigit(character)) {
                        num = 0;

                        while (true) {
                            num = num * 10 + (character - '0');

                            if (stack.isEmpty() || !Character.isDigit(stack.peek()))
                                break;

                            character = stack.pop();
                        }

                        if (op == '#')
                            result = num;
                        else if (op == '+')
                            result += num;
                        else
                            result -= num;

                        op = '#';
                    }
                    else if (character == '+') {
                        op = '+';
                    }
                    else {
                        // CHANGED: "--" cancels out to "+"
                        op = (op == '-') ? '+' : '-';
                    }

                    character = stack.pop();
                }

                String value = String.valueOf(result);

                for (int j = value.length() - 1; j >= 0; j--)
                    stack.push(value.charAt(j));

                // Preserve unary minus
                if (op == '-')
                    stack.push('-');
            }
            else {
                stack.push(ch);
            }
        }

        // CHANGED: haveNumber removed

        while (!stack.isEmpty()) {
            char ch = stack.pop();

            if (Character.isDigit(ch)) {
                num = 0;

                while (true) {
                    num = num * 10 + (ch - '0');

                    if (stack.isEmpty() || !Character.isDigit(stack.peek()))
                        break;

                    ch = stack.pop();
                }

                if (operation == '#')
                    ans = num;
                else if (operation == '+')
                    ans += num;
                else
                    ans -= num;

                operation = '#';

                if (ch == '+' || ch == '-')
                    operation = ch;
            }
            else if (ch == '+') {
                operation = '+';
            }
            else {
                // CHANGED: "--" cancels out to "+", and a leading '-' acts as 0 - num
                operation = (operation == '-') ? '+' : '-';
            }
        }

        if (operation == '-')
            return -ans;

        return ans;
    }
}
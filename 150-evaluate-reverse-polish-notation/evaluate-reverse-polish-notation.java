class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length, ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                switch (s) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                }
                stack.push(res);
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}
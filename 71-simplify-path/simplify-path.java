class Solution {
    public String simplifyPath(String path) {
        int len = path.length();
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < len; i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                String str = temp.toString();
                if (str.equals("") || str.equals(".")) {
                    temp = new StringBuilder();
                    continue;
                } else if (str.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else
                    stack.push(str);
                temp = new StringBuilder();
            } else
                temp.append(ch);
        }

        String str = temp.toString();

        if (str.equals("") || str.equals(".")) {
        } else if (str.equals("..")) {
            if (!stack.isEmpty())
                stack.pop();
        } else {
            stack.push(str);
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()) {
            str = stack.pop();
            ans.insert(0, str);
            ans.insert(0, "/");
        }

        return ans.toString();
    }
}
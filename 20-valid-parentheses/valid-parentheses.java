class Solution {
    char stack[] = new char[100000];
    int top = -1;

    public void push(char ch) {
        if (top != stack.length - 1)
            stack[++top] = ch;
    }

    public char pop() {
        if (top != -1) {
            char toReturn = stack[top];
            top--;
            return toReturn;
        }
        return 'a';
    }

    public boolean isMatching(char open, char close) {
        if (open == '(')
            return close == ')';
        else if (open == '[')
            return close == ']';
        else if (open == '{')
            return close == '}';
        else
            return false;
    }

    public boolean isValid(String s) {
        int len = s.length(), i;
        char ch, chr;
        for (i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                push(ch);
            else {
                chr = pop();
                if (!isMatching(chr, ch))
                    return false;
            }
        }
        return top == -1;
    }
}
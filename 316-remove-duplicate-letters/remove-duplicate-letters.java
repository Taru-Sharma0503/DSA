class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] freq2 = new int[26];
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;
            if (freq2[ch - 'a'] > 0) {
                continue;
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (ch < top && freq[top - 'a'] > 0) {
                        stack.pop();
                        freq2[top - 'a']--;
                    } else {
                        break;
                    }
                }
                stack.push(ch);
                freq2[ch-'a']++;
            }
        }

        while (!stack.isEmpty())
            ans.append(stack.pop());

        return ans.reverse().toString();
    }
}
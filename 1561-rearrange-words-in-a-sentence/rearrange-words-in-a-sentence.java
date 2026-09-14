class Solution {
    public String arrangeWords(String text) {
        StringBuilder ans = new StringBuilder();
        String words[] = text.split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int idx = 0; idx < words.length; idx++) {
            ans.append(words[idx]);
            if (idx != words.length - 1)
                ans.append(" ");
        }

        ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));

        for (int i = 1; i < ans.length(); i++) {
            if (ans.charAt(i) != ' ')
                ans.setCharAt(i, Character.toLowerCase(ans.charAt(i)));
        }

        return ans.toString();
    }
}
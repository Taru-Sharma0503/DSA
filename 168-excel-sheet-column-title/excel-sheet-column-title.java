class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            ans.insert(0, (char) ('A' + rem));
            columnNumber /= 26;
        }

        return ans.toString();
    }
}
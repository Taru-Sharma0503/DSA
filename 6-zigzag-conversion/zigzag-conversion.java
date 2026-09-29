class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder row[] = new StringBuilder[numRows + 1];
        StringBuilder ans = new StringBuilder();
        boolean increase = true;
        int rowNo = 1;

        for (int i = 1; i <= numRows; i++)
            row[i] = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            row[rowNo] = row[rowNo].append(ch);
            if (rowNo == 1) {
                increase = true;
            }
            if (rowNo == numRows) {
                increase = false;
            }
            if (increase)
                rowNo++;
            else
                rowNo--;
        }

        for (int i = 1; i <= numRows; i++) {
            ans.append(row[i]);
        }

        return ans.toString();
    }
}
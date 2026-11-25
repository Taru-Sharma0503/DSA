class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i, j;
        boolean row[][] = new boolean[10][10];
        boolean col[][] = new boolean[10][10];
        boolean boxes[][] = new boolean[10][10];

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                int box = (i / 3) * 3 + (j / 3);

                if (row[i][num] || col[j][num] || boxes[box][num])
                    return false;

                row[i][num] = true;
                col[j][num] = true;
                boxes[box][num] = true;
            }
        }
        return true;
    }
}
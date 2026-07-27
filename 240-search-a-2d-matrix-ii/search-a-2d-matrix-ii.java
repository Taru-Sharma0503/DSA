class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, row = 0, col = n - 1;

        while (row < m && col >=0) {
            if (target == matrix[row][col])
                return true;

            if (target < matrix[row][col])
                col--;
            else
                row++;
        }

        return false;
    }
}
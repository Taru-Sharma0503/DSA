class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, val, left = 0, right = m * n - 1, row, col;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            row = mid / n;
            col = mid % n;
            val = matrix[row][col];
            if (val == target)
                return true;
            else if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
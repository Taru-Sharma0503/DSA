class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int i = 0, j = 0, idx = -1;
        boolean isGoingUp = true;

        while (idx < m * n - 1) {
            ans[++idx] = mat[i][j];
            if (idx == m * n - 1)
                break;

            if (isGoingUp) {
                if (i - 1 >= 0 && j + 1 < n) {
                    i--;
                    j++;
                } else if (j + 1 < n) {
                    j++;
                    isGoingUp = false;
                } else if (i + 1 < m) {
                    i++;
                    isGoingUp = false;
                } else
                    break;
            }

            else {
                if (i + 1 < m && j - 1 >= 0) {
                    i++;
                    j--;
                } else if (i + 1 < m) {
                    i++;
                    isGoingUp = true;
                } else if (j + 1 < n) {
                    j++;
                    isGoingUp = true;
                } else
                    break;
            }
        }

        return ans;
    }
}
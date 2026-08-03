class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int element = mat[i][j];
                flag = false;

                if (j > 0 && mat[i][j - 1] > element ||
                        j < n - 1 && mat[i][j + 1] > element ||
                        i > 0 && mat[i - 1][j] > element ||
                        i < m - 1 && mat[i + 1][j] > element)
                    flag = true;

                if (!flag)
                    return new int[] { i, j };
            }
        }

        return new int[] { -1, -1 };
    }
}
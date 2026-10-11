class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int num = 1, i = 0, j = 0, direction = 2;
        ans[0][0] = 1;
        num++;

        while (true) {
            if (direction == 2) {
                if (canGoRight(ans, i, j)) {
                    ans[i][++j] = num++;
                } else {
                    if (canGoDown(ans, i, j)) {
                        ans[++i][j] = num++;
                        direction = -1;
                    } else
                        break;
                }
            }

            if (direction == -1) {
                if (canGoDown(ans, i, j)) {
                    ans[++i][j] = num++;
                } else {
                    if (canGoLeft(ans, i, j)) {
                        ans[i][--j] = num++;
                        direction = -2;
                    } else
                        break;
                }
            }

            if (direction == -2) {
                if (canGoLeft(ans, i, j)) {
                    ans[i][--j] = num++;
                } else {
                    if (canGoUp(ans, i, j)) {
                        ans[--i][j] = num++;
                        direction = 1;
                    } else
                        break;
                }
            }

            if (direction == 1) {
                if (canGoUp(ans, i, j)) {
                    ans[--i][j] = num++;
                } else {
                    if (canGoRight(ans, i, j)) {
                        ans[i][++j] = num++;
                        direction = 2;
                    } else
                        break;
                }
            }
        }

        return ans;
    }

    public boolean canGoUp(int[][] ans, int i, int j) {
        if (i == 0)
            return false;

        return ans[--i][j] == 0 ? true : false;
    }

    public boolean canGoDown(int[][] ans, int i, int j) {
        if (i == ans.length - 1)
            return false;

        return ans[++i][j] == 0 ? true : false;
    }

    public boolean canGoRight(int[][] ans, int i, int j) {
        if (j == ans.length - 1)
            return false;

        return ans[i][++j] == 0 ? true : false;
    }

    public boolean canGoLeft(int[][] ans, int i, int j) {
        if (j == 0)
            return false;

        return ans[i][--j] == 0 ? true : false;
    }
}
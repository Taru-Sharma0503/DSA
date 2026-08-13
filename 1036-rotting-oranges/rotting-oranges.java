class Solution {
    int ans = 0;
    int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        rotten(q, grid);

        if (isRotten(grid))
            return -1;

        return ans;
    }

    public boolean isRotten(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return true;
            }
        }

        return false;
    }

    public void rotten(Queue<int[]> q, int[][] grid) {

        while (!q.isEmpty()) {

            int size = q.size();
            boolean changed = false;

            for (int k = 0; k < size; k++) {

                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.offer(new int[]{i - 1, j});
                    changed = true;
                }

                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.offer(new int[]{i, j - 1});
                    changed = true;
                }

                if (i < m - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.offer(new int[]{i + 1, j});
                    changed = true;
                }

                if (j < n - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.offer(new int[]{i, j + 1});
                    changed = true;
                }
            }

            if (changed)
                ans++;
        }
    }
}
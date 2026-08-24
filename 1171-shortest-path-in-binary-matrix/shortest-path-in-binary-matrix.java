class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, ans = Integer.MAX_VALUE, level = 0;
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        if (grid[0][0] == 1)
            return -1;

        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int idx = 0; idx < size; idx++) {
                int node[] = queue.removeFirst();
                int i = node[0];
                int j = node[1];

                if (i == n - 1 && j == n - 1) {
                    ans = Math.min(ans, level);
                    continue;
                }

                if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0 && !visited[i - 1][j - 1]) {
                    queue.add(new int[] { i - 1, j - 1 });
                    visited[i - 1][j - 1] = true;
                }

                if (i - 1 >= 0 && grid[i - 1][j] == 0 && !visited[i - 1][j]) {
                    queue.add(new int[] { i - 1, j });
                    visited[i - 1][j] = true;
                }

                if (i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] == 0 && !visited[i - 1][j + 1]) {
                    queue.add(new int[] { i - 1, j + 1 });
                    visited[i - 1][j + 1] = true;
                }

                if (j - 1 >= 0 && grid[i][j - 1] == 0 && !visited[i][j - 1]) {
                    queue.add(new int[] { i, j - 1 });
                    visited[i][j - 1] = true;
                }

                if (j + 1 < n && grid[i][j + 1] == 0 && !visited[i][j + 1]) {
                    queue.add(new int[] { i, j + 1 });
                    visited[i][j + 1] = true;
                }

                if (i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 0 && !visited[i + 1][j - 1]) {
                    queue.add(new int[] { i + 1, j - 1 });
                    visited[i + 1][j - 1] = true;
                }

                if (i + 1 < n && grid[i + 1][j] == 0 && !visited[i + 1][j]) {
                    queue.add(new int[] { i + 1, j });
                    visited[i + 1][j] = true;
                }

                if (i + 1 < n && j + 1 < n && grid[i + 1][j + 1] == 0 && !visited[i + 1][j + 1]) {
                    queue.add(new int[] { i + 1, j + 1 });
                    visited[i + 1][j + 1] = true;
                }
            }
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
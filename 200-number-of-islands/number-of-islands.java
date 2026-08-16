class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int components=0;
        int visited[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, i, j, visited);
                    components++;
                }
            }
        }

        return components;
    }

    public void dfs(char[][] grid, int i, int j, int[][] visited) {
        visited[i][j] = 1;

        if (i > 0 && grid[i - 1][j] == '1' && visited[i - 1][j] == 0)
            dfs(grid, i - 1, j, visited);

        if (j > 0 && grid[i][j - 1] == '1' && visited[i][j - 1] == 0)
            dfs(grid, i, j - 1, visited);

        if (i < grid.length - 1 && grid[i + 1][j] == '1' && visited[i + 1][j] == 0)
            dfs(grid, i + 1, j, visited);

        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && visited[i][j + 1] == 0)
            dfs(grid, i, j + 1, visited);
    }
}
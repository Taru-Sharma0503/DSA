class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int square = grid[row][col];

        dfs(grid, row, col, color, square, visited);

        return grid;
    }

    public void dfs(int[][] grid, int i, int j, int color, int square, boolean[][] visited) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != square)
            return;

        visited[i][j] = true;
        boolean border = i == 0 || j == 0 ||
                i == grid.length - 1 || j == grid[0].length - 1 ||
                grid[i - 1][j] != square ||
                grid[i + 1][j] != square ||
                grid[i][j - 1] != square ||
                grid[i][j + 1] != square;

        dfs(grid, i - 1, j, color, square, visited);

        dfs(grid, i, j - 1, color, square, visited);

        dfs(grid, i + 1, j, color, square, visited);

        dfs(grid, i, j + 1, color, square, visited);

        if (border)
            grid[i][j] = color;
    }
}
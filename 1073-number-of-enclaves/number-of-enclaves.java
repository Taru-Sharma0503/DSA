class Solution {

    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    List<List<Pair>> components = new ArrayList<>();

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair> component = new ArrayList<>();
                    dfs(grid, i, j, component, visited);
                    components.add(component);
                }
            }
        }

        for (List<Pair> pairList : components) {
            int flag = 0;
            for (Pair pair : pairList) {
                if (pair.i == 0 || pair.j == 0 || pair.i == m - 1 || pair.j == n - 1) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0)
                ans += pairList.size();
        }

        return ans;
    }

    public void dfs(int[][] grid, int i, int j, List<Pair> component, boolean[][] visited) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;
        component.add(new Pair(i, j));

        dfs(grid, i - 1, j, component, visited);
        dfs(grid, i + 1, j, component, visited);
        dfs(grid, i, j - 1, component, visited);
        dfs(grid, i, j + 1, component, visited);
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int parent[] = new int[m * n];
        int size[] = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;

                islands++;
                int idx = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1') {
                    if (union(grid, idx, (i - 1) * n + j, parent, size))
                        islands--;
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    if (union(grid, idx, (i) * n + (j - 1), parent, size))
                        islands--;
                }
            }
        }

        return islands;
    }

    public boolean union(char[][] grid, int a, int b, int parent[], int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB)
            return false;

        if (size[rootA] <= size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return true;
    }

    public int find(int i, int[] parent) {
        if (parent[i] != i)
            parent[i] = find(parent[i], parent);
        return parent[i];
    }
}
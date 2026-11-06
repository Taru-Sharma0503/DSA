class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int parent[] = new int[m * n];
        boolean isparent[] = new boolean[m * n];
        int size[] = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
            isparent[i] = false;
            size[i] = 1;
        }

        int servers = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                int idx = i * n + j;
                for (int k = 0; k < n; k++) {
                    if (k != j && grid[i][k] == 1) {
                        union(idx, i * n + k, parent, size, isparent);
                    }
                }

                for (int k = 0; k < m; k++) {
                    if (k != i && grid[k][j] == 1) {
                        union(idx, k * n + j, parent, size, isparent);
                    }
                }
            }
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i && isparent[i] == false)
                continue;

            servers++;
        }

        return servers;
    }

    public boolean union(int a, int b, int parent[], int[] size, boolean[] isparent) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB)
            return false;

        if (size[rootA] <= size[rootB]) {
            parent[rootA] = rootB;
            isparent[rootB] = true;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            isparent[rootA] = true;
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
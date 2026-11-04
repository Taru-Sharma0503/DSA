class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length, maxIsland = 0;
        int parent[] = new int[n * n];
        int size[] = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                int idx = i * n + j;
                if (i > 0 && grid[i - 1][j] == 1) {
                    union(idx, (i - 1) * n + j, parent, size);
                }

                if (j > 0 && grid[i][j - 1] == 1) {
                    union(idx, (i) * n + (j - 1), parent, size);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int ans = 1;
                    int left = -1, right = -1, up = -1, down = -1;

                    if (j > 0 && grid[i][j - 1] == 1)
                        left = find(i * n + (j - 1), parent);
                    if (j < n - 1 && grid[i][j + 1] == 1)
                        right = find(i * n + (j + 1), parent);
                    if (i > 0 && grid[i - 1][j] == 1)
                        up = find((i - 1) * n + j, parent);
                    if (i < n - 1 && grid[i + 1][j] == 1)
                        down = find((i + 1) * n + j, parent);

                    if (left != -1)
                        ans += size[left];
                    if (right != -1 && right != left)
                        ans += size[right];
                    if (up != -1 && up != left && up != right)
                        ans += size[up];
                    if (down != -1 && down != left && down != right && down != up)
                        ans += size[down];

                    maxIsland = Math.max(maxIsland, ans);
                }
            }
        }

        return maxIsland != 0 ? maxIsland : n * n;
    }

    public boolean union(int a, int b, int parent[], int[] size) {
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
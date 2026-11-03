class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        int components = n;

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(isConnected, i, j, parent, size)) {
                        components--;
                    }
                }
            }
        }

        return components;
    }

    public boolean union(int[][] isConnected, int a, int b, int[] parent, int[] size) {
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
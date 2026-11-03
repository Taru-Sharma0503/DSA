class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if (!union(edges, a, b, parent, size)) {
                ans[0] = a;
                ans[1] = b;
            }
        }

        return ans;
    }

    public boolean union(int[][] edges, int a, int b, int[] parent, int[] size) {
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
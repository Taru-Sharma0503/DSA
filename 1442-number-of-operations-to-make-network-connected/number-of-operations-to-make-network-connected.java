class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int cables = 0;
        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];

            if (!union(a, b, parent, size)) {
                cables++;
            }
        }

        int distinctParents = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                distinctParents++;
        }

        if (cables >= (distinctParents - 1))
            return distinctParents - 1;
        else
            return -1;
    }

    public boolean union(int a, int b, int[] parent, int[] size) {
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
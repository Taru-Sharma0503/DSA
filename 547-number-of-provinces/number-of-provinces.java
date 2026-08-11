class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, n = isConnected[0].length, ans = 0;
        List<Integer> graph[] = new ArrayList[m];
        boolean visited[] = new boolean[m];

        for (int i = 0; i < m; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (isConnected[i][j] == 1)
                    graph[i].add(j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (visited[i])
                continue;

            dfs(i, graph, visited);
            ans++;
        }

        return ans;
    }

    public void dfs(int node, List<Integer> graph[], boolean visited[]) {
        visited[node] = true;

        for (int nbr : graph[node]) {
            if (!visited[nbr])
                dfs(nbr, graph, visited);
        }
    }
}
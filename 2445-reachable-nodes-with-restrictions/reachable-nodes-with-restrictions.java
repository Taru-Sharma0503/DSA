class Solution {
    int ans = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer> graph[] = new ArrayList[n];
        HashSet<Integer> restrictedSet = new HashSet<>();

        for (int num : restricted)
            restrictedSet.add(num);

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        dfs(graph, 0, visited, restrictedSet);
        return ans;
    }

    public void dfs(List<Integer> graph[], int node, boolean[] visited, HashSet<Integer> restrictedSet) {
        ans++;
        visited[node] = true;

        for (int nbr : graph[node]) {
            if (visited[nbr] || restrictedSet.contains(nbr))
                continue;

            dfs(graph, nbr, visited, restrictedSet);
        }
    }
}
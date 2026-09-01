class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;

        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[m];
            boolean[] path = new boolean[m];

            if (!hasCycle(graph, i, visited, path)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean hasCycle(int[][] graph, int i, boolean[] visited, boolean[] path) {
        if (path[i])
            return true;

        if (visited[i])
            return false;

        if (graph[i].length == 0)
            return false;

        visited[i] = true;
        path[i] = true;

        for (int nbr : graph[i]) {
            if (hasCycle(graph, nbr, visited, path))
                return true;
        }

        path[i] = false;

        return false;
    }
}
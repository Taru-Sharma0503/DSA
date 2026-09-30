class Solution {
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        List<int[]> graph[] = new ArrayList[n];
        boolean canReach[] = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        canReach[0] = true;

        for (int i = 0; i < n - 1; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            graph[u].add(new int[]{v, 1});
            graph[v].add(new int[]{u, 0});
        }

        markReach(graph, 0, canReach);

        return ans;
    }

    public void markReach(List<int[]> graph[], int u, boolean[] canReach) {

        for (int[] edge : graph[u]) {
            int v = edge[0];
            int cost = edge[1];

            if (!canReach[v]) {
                ans += cost;
                canReach[v] = true;
                markReach(graph, v, canReach);
            }
        }
    }
}
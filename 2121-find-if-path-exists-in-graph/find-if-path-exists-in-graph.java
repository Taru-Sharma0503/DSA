class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return hasPath(graph, source, destination, visited);
    }

    public boolean hasPath(ArrayList<ArrayList<Integer>> graph, int src, int dst, boolean[] visited) {
        if (src == dst)
            return true;

        visited[src] = true;
        for (int nbr : graph.get(src)) {
            if (!visited[nbr]) {
                boolean hasNbrPath = hasPath(graph, nbr, dst, visited);
                if (hasNbrPath)
                    return true;
            }
        }

        return false;
    }
}
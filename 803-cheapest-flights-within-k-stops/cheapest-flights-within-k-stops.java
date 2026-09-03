class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = path.clone();

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int wt = flight[2];

                if (path[u] == Integer.MAX_VALUE)
                    continue;

                if (path[u] + wt < temp[v])
                    temp[v] = path[u] + wt;
            }

            path = temp;
        }

        return path[dst] == Integer.MAX_VALUE ? -1 : path[dst];
    }
}
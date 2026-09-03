class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int len = times.length, max = Integer.MIN_VALUE;
        int path[] = new int[n + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[k] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int wt = time[2];

                if (path[u] == Integer.MAX_VALUE)
                    continue;

                if (path[u] + wt < path[v])
                    path[v] = path[u] + wt;
            }
        }

        for (int i = 1; i < path.length; i++)
            max = Math.max(max, path[i]);

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
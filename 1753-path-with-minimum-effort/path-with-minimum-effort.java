class Solution {

    class Edge {
        int row;
        int col;
        int effort;

        Edge(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int dist[][] = new int[m][n];
        int directions[][] = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        boolean visited[][] = new boolean[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.add(new Edge(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            for (int[] direction : directions) {
                int nr = edge.row + direction[0];
                int nc = edge.col + direction[1];

                if (nr < 0 || nc < 0 || nr > m - 1 || nc > n - 1)
                    continue;

                if (visited[nr][nc])
                    continue;

                visited[edge.row][edge.col] = true;
                int diff = Math.abs(heights[edge.row][edge.col] - heights[nr][nc]);
                int newEffort = Math.max(edge.effort, diff);

                if (newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    pq.add(new Edge(nr, nc, newEffort));
                }
            }

            if (edge.row == m - 1 && edge.col == n - 1)
                return edge.effort;
        }

        return -1;
    }
}
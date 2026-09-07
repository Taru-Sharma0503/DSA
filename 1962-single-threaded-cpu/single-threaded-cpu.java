class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length, idx = -1, ptr = 0;

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] != b[1]
                ? a[1] - b[1]
                : a[0] - b[0]
        );

        int[] ans = new int[n];
        long time = arr[0][0];

        while (idx < n - 1) {

            while (ptr < n && arr[ptr][0] <= time) {
                pq.add(new int[] { arr[ptr][2], arr[ptr][1] });
                ptr++;
            }

            if (pq.isEmpty()) {
                time = arr[ptr][0];
                continue;
            }

            int[] task = pq.poll();

            ans[++idx] = task[0];
            time += task[1];
        }

        return ans;
    }
}
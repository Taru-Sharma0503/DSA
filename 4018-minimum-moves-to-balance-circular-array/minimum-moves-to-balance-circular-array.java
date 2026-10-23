
class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        long operations = 0, sum = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0)
                idx = i;
            sum += balance[i];
        }

        if (sum < 0)
            return -1;
        if (idx == -1)
            return 0;

        long deficit = -(long) balance[idx];
        int left = (idx - 1 + n) % n;
        int right = (idx + 1) % n;
        int dist = 1;

        while (deficit > 0 && dist < n) {
            long available = balance[left];

            if (left != right)
                available += balance[right];

            long take = Math.min(deficit, available);
            operations += take * dist;
            deficit -= take;

            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            dist++;
        }

        return deficit == 0 ? operations : -1;
    }
}

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int ans[] = new int[n + 2];

        for (int[] edge : edges) {
            ans[edge[0]]++;
            ans[edge[1]]++;
        }

        for (int i = 1; i <= n + 1; i++) {
            if (ans[i] == n)
                return i;
        }

        return -1;
    }
}
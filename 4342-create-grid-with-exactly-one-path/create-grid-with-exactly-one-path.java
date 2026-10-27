class Solution {
    public String[] createGrid(int m, int n) {
        String ans[] = new String[m];
        StringBuilder toAdd = new StringBuilder();
        int idx = -1;

        for (int i = 0; i < m; i++) {
            toAdd = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1)
                    toAdd.append('.');
                else
                    toAdd.append('#');
            }

            ans[++idx] = toAdd.toString();
        }

        return ans;
    }
}
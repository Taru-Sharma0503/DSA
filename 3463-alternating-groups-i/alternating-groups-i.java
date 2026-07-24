class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length, ans = 0;
        int[] colorsArr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            colorsArr[i] = colors[i];
            colorsArr[i + n] = colors[i];
        }

        for (int i = 0; i < n; i++) {
            if (colorsArr[i] == colorsArr[i + 2] && colorsArr[i + 1] != colorsArr[i])
                ans++;
        }

        return ans;
    }
}
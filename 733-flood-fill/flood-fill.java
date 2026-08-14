class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];

        if (startingColor == color)
            return image;

        fill(image, sr, sc, color, startingColor, image[0].length, image.length);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int startingColor, int n, int m) {
        image[sr][sc] = color;

        if (sr > 0 && image[sr - 1][sc] != startingColor &&
                sc > 0 && image[sr][sc - 1] != startingColor &&
                sr < m - 1 && image[sr + 1][sc] != startingColor &&
                sc < n - 1 && image[sr][sc + 1] != startingColor)
            return;

        if (sr > 0 && image[sr - 1][sc] == startingColor)
            fill(image, sr - 1, sc, color, startingColor, n, m);

        if (sc > 0 && image[sr][sc - 1] == startingColor)
            fill(image, sr, sc - 1, color, startingColor, n, m);

        if (sr < m - 1 && image[sr + 1][sc] == startingColor)
            fill(image, sr + 1, sc, color, startingColor, n, m);

        if (sc < n - 1 && image[sr][sc + 1] == startingColor)
            fill(image, sr, sc + 1, color, startingColor, n, m);
    }
}
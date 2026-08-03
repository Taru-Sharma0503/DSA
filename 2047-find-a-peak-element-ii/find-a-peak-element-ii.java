class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length, s = 0, e = n - 1, mid;
        int largestIdx[] = new int[2];

        while (s <= e) {
            mid = s + (e - s) / 2;
            largestIdx = largestOfCol(mat, mid);

            int left = (largestIdx[1] == 0) ? -1 : mat[largestIdx[0]][largestIdx[1] - 1];
            int right = (largestIdx[1] == n - 1) ? -1 : mat[largestIdx[0]][largestIdx[1] + 1];

            if (left < mat[largestIdx[0]][largestIdx[1]] &&
                right < mat[largestIdx[0]][largestIdx[1]])
                return new int[] { largestIdx[0], largestIdx[1] };

            else if (left > mat[largestIdx[0]][largestIdx[1]])
                e = mid - 1;
            else
                s = mid + 1;
        }

        return new int[] { -1, -1 };
    }

    public int[] largestOfCol(int mat[][], int col) {
        int largest = Integer.MIN_VALUE, idx = -1;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > largest) {
                largest = mat[i][col];
                idx = i;
            }
        }

        return new int[] { idx, col };
    }
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        if (d == 0)
            return arr1.length;

        int ans = 0;

        for (int num1 : arr1) {
            if (valid(arr2, num1, d))
                ans++;
        }

        return ans;
    }

    public boolean valid(int[] arr2, int num1, int d) {
        int s = 0, e = arr2.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (arr2[m] >= num1 - d && arr2[m] <= num1 + d) {
                return false;
            } else if (arr2[m] < num1 - d)
                s = m + 1;
            else
                e = m - 1;
        }

        return true;
    }
}
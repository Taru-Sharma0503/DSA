class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length, max = Integer.MIN_VALUE, ans = 0;

        for (int quantity : quantities)
            max = Math.max(max, quantity);

        int s = 1, e = max;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int retailCount = isValid(mid, quantities);
            if (retailCount <= n) {
                ans = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }

        return ans;
    }

    public int isValid(int n, int arr[]) {
        int stores = 0;

        for (int element : arr) {
            stores += Math.ceil((double) element / n);
        }

        return stores;
    }
}
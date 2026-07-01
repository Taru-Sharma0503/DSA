class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, i, pos = -1, s = 0, e = n - 1;
        List<Integer> ans = new ArrayList<>();

        for (i = 0; i < n; i++) {
            if (arr[i] == x) {
                ans.add(arr[i]);
                s = i - 1;
                e = i + 1;
                break;
            } else if (arr[i] > x) {
                e = i;
                s = i - 1;
                break;
            }
        }

        if (i == n) {
            s = n - 1;
            e = n;
        }

        while (ans.size() < k) {
            if (s < 0) {
                ans.add(arr[e]);
                e++;
            } else if (e >= n) {
                ans.add(arr[s]);
                s--;
            } else if (Math.abs(arr[s] - x) <= Math.abs(arr[e] - x)) {
                ans.add(arr[s]);
                s--;
            } else {
                ans.add(arr[e]);
                e++;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
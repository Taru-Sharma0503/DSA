class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int n = arr.length, rnk = 1, right = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        if (n == 0)
            return arr;

        map.put(sorted[0], 1);
        while (right < n) {
            while (right < n && sorted[right] == sorted[right - 1]) {
                map.put(sorted[right], rnk);
                right++;
            }
            rnk++;
            if (right < n)
                map.put(sorted[right], rnk);
            right++;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, ans = 0, s = 0, e = n;

        while (s <= e) {
            int h = s + (e - s) / 2;

            if (ishIndex(h, citations)) {
                ans = h;
                s = h + 1;
            }

            else {
                e = h - 1;
            }
        }

        return ans;
    }

    public boolean ishIndex(int h, int[] citations) {
        int n = citations.length, s = 0, e = n - 1, m;

        while (s <= e) {
            m = s + (e - s) / 2;

            if (citations[m] >= h) {
                if (n - m >= h)
                    return true;
                e = m - 1;
            }

            else {
                s = m + 1;
            }
        }

        return false;
    }
}
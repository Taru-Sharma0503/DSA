class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length, s = 1, e = position[n - 1] - position[0];

        while (s <= e) {
            int mid = s + (e - s) / 2;
            boolean canPlace = place(m, mid, position);

            if (canPlace)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return e;
    }

    public boolean place(int m, int mid, int[] position) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                count++;
                last = position[i];

                if (count == m)
                    return true;
            }
        }

        return false;
    }
}
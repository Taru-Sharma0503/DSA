class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long ans = 0;

        for (int i = 0; i < gifts.length; i++)
            pq.add(new int[] { gifts[i], i });

        while (k > 0) {
            int[] arr = pq.poll();
            int ele = arr[0];
            int idx = arr[1];

            gifts[idx] = (int) Math.floor(Math.sqrt(ele));
            pq.add(new int[] { gifts[idx], idx });

            k--;
        }

        for (int gift : gifts)
            ans += gift;

        return ans;
    }
}
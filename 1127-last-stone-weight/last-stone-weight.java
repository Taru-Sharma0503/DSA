class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones)
            queue.add(stone);

        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            if (x == y)
                continue;
            queue.add(y - x);
        }

        return queue.size() == 0 ? 0 : queue.poll();
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, count = 1;
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums)
            que.add(num);

        while (count != k) {
            que.poll();
            count++;
        }

        return que.peek();
    }
}
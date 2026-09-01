class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length, idx = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int arr[] = new int[n];

        for (int num : nums)
            queue.add(num);

        while (!queue.isEmpty()) {
            int aliceMin = queue.poll();
            int bobMin = queue.poll();
            arr[++idx] = bobMin;
            arr[++idx] = aliceMin;
        }

        return arr;
    }
}
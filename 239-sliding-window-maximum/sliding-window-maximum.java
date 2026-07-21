import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (right = 0; right < k; right++) {
            queue.add(new int[] { nums[right], right });
        }

        list.add(queue.peek()[0]);
        if (right < n)
            queue.add(new int[] { nums[right], right });

        left = 1;
        while (right < n) {
            while (queue.peek()[1] < left || queue.peek()[1] > right)
                queue.poll();

            list.add(queue.peek()[0]);
            left++;
            right++;
            if (right < n)
                queue.add(new int[] { nums[right], right });
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}
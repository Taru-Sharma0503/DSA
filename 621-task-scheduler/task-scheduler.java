import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length, maxTime = len * (n + 1), ans = 0;
        boolean notAvailableTime[] = new boolean[maxTime + 1];
        int time[] = new int[26];
        int freq[] = new int[26];

        for (char task : tasks)
            freq[task - 'A']++;

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> freq[b] - freq[a]);

        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                pq.offer(i);

        while (!pq.isEmpty()) {
            int idx = pq.poll();

            if (time[idx] == 0) {
                time[idx] = 1;

                while (notAvailableTime[time[idx]])
                    time[idx]++;
            } else {
                time[idx] += n + 1;

                while (notAvailableTime[time[idx]])
                    time[idx]++;
            }

            notAvailableTime[time[idx]] = true;
            ans = Math.max(ans, time[idx]);

            freq[idx]--;

            if (freq[idx] > 0)
                pq.offer(idx);
        }

        return ans;
    }
}
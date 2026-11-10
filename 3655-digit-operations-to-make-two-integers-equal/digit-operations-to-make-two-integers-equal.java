
class Solution {

    public int minOperations(int n, int m) {

        if (isPrime(n) || isPrime(m))
            return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        HashMap<Integer, Integer> visited = new HashMap<>();

        pq.offer(new int[]{n, n});
        visited.put(n, n);

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int num = curr[0];
            int cost = curr[1];

            if (visited.get(num) < cost)
                continue;

            if (num == m)
                return cost;

            StringBuilder num1 = new StringBuilder(Integer.toString(num));

            for (int i = 0; i < num1.length(); i++) {

                char ogNum = num1.charAt(i);

                if (ogNum != '9') {
                    num1.setCharAt(i, (char)(ogNum + 1));

                    int next = Integer.parseInt(num1.toString());

                    if (!isPrime(next) &&
                        (!visited.containsKey(next) ||
                         cost + next < visited.get(next))) {

                        visited.put(next, cost + next);
                        pq.offer(new int[]{next, cost + next});
                    }

                    num1.setCharAt(i, ogNum);
                }

                if (ogNum != '0') {
                    num1.setCharAt(i, (char)(ogNum - 1));

                    int next = Integer.parseInt(num1.toString());

                    if (!isPrime(next) &&
                        (!visited.containsKey(next) ||
                         cost + next < visited.get(next))) {

                        visited.put(next, cost + next);
                        pq.offer(new int[]{next, cost + next});
                    }

                    num1.setCharAt(i, ogNum);
                }
            }
        }

        return -1;
    }

    public boolean isPrime(int n) {

        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}

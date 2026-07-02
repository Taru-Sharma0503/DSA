class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || temperatures[i] < temperatures[stack.peek()])
                stack.push(i);
            else {
                int temp = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int topIdx = stack.pop();
                    ans[topIdx] = i - topIdx;
                }
                stack.push(i);
            }
        }

        return ans;
    }
}
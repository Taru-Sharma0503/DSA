class StockSpanner {
    int stack[][];
    int top;

    public StockSpanner() {
        stack = new int[10001][2];
        top = -1;
    }

    public int next(int price) {
        int ans = 1;
        int currTop = top;
        while (currTop >= 0 && stack[currTop][0] <= price) {
            ans += stack[currTop][1];
            currTop -= stack[currTop][1];
        }
        stack[++top] = new int[] { price, ans };
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
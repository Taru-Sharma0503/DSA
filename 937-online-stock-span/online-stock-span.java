class StockSpanner {
    int[] price;
    int[] span;
    int top;

    public StockSpanner() {
        price = new int[10001];
        span = new int[10001];
        top = -1;
    }

    public int next(int currPrice) {
        int currSpan = 1;

        while (top >= 0 && price[top] <= currPrice) {
            currSpan += span[top];
            top--;
        }

        top++;
        price[top] = currPrice;
        span[top] = currSpan;

        return currSpan;
    }
}
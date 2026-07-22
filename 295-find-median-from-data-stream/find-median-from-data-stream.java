class MedianFinder {
    PriorityQueue<Integer> minQue;
    PriorityQueue<Integer> maxQue;

    public MedianFinder() {
        this.minQue = new PriorityQueue<>();
        this.maxQue = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (maxQue.isEmpty() || num <= maxQue.peek())
            maxQue.add(num);
        else
            minQue.add(num);

        if (minQue.size() - maxQue.size() == 2) {
            int ele = minQue.poll();
            maxQue.add(ele);
        } else if (maxQue.size() - minQue.size() == 2) {
            int ele = maxQue.poll();
            minQue.add(ele);
        }
    }

    public double findMedian() {
        int size = minQue.size() + maxQue.size();

        if (size % 2 != 0) {
            if (minQue.size() > maxQue.size())
                return (double) minQue.peek();
            else
                return (double) maxQue.peek();
        }

        return (double) (minQue.peek() + maxQue.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
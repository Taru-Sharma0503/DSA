class FreqStack {
    int maxFreq;
    HashMap<Integer, Stack<Integer>> map;
    HashMap<Integer, Integer> freqMap;

    public FreqStack() {
        maxFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);

        int freq = freqMap.get(val);
        maxFreq = Math.max(maxFreq, freq);

        if (!map.containsKey(freq))
            map.put(freq, new Stack<>());
        map.get(freq).push(val);
    }

    public int pop() {
        int val = map.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);

        if (map.get(maxFreq).isEmpty())
            maxFreq--;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp = new TreeMap<>();
        temp.put(timestamp, value);

        if (!map.containsKey(key)) {
            map.put(key, temp);
        } else
            map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        Integer prev = map.get(key).floorKey(timestamp);

        if (prev == null)
            return "";

        return map.get(key).get(prev);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
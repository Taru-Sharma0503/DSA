class RandomizedSet {

    HashSet<Integer> set;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;
    int idx = 0;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        random = new Random();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (set.contains(val))
            return false;

        set.add(val);
        list.add(val);
        map.put(val, idx);
        idx++;

        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val))
            return false;

        set.remove(val);

        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);
        int randomIdx = map.get(val);
        int randomVal = list.get(randomIdx);

        list.set(randomIdx, lastVal);
        list.set(lastIdx, randomVal);

        map.put(lastVal, randomIdx);
        map.remove(val);

        list.remove(lastIdx);
        idx--;

        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}
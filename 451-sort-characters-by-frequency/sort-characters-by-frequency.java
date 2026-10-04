class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int val = map.get(ch);

            for (int i = 0; i < val; i++)
                ans.append(ch);
        }

        return ans.toString();
    }
}
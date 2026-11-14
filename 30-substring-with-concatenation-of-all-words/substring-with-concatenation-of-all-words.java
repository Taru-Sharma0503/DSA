class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length * words[0].length();
        List<Integer> list = new ArrayList<>();
        if (len > s.length())
            return list;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= s.length() - len; i++) {
            String str = s.substring(i, i + len);
            int idx = 0;
            HashMap<String, Integer> fmap = new HashMap<>();
            while (idx <= len - words[0].length()) {
                String st = str.substring(idx, idx + words[0].length());
                fmap.put(st, fmap.getOrDefault(st, 0) + 1);
                idx += words[0].length();
            }

            if (map.equals(fmap))
                list.add(i);
        }

        return list;
    }
}
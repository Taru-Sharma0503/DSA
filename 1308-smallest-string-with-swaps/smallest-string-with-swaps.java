
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        int parent[] = new int[len];
        int size[] = new int[len];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);

            union(a, b, parent, size);
        }

        for (int i = 0; i < len; i++) {
            int root = find(i, parent);

            if (!map.containsKey(root)) {
                map.put(root, new HashSet<>());
            }
            map.get(root).add(i);
        }

        char[] result = s.toCharArray();

        for (int root : map.keySet()) {
            List<Integer> indices = new ArrayList<>(map.get(root));
            Collections.sort(indices);

            List<Character> characters = new ArrayList<>();

            for (int index : indices) {
                characters.add(s.charAt(index));
            }

            Collections.sort(characters);

            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = characters.get(i);
            }
        }

        return new String(result);
    }

    public boolean union(int a, int b, int parent[], int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB)
            return false;

        if (size[rootA] <= size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return true;
    }

    public int find(int i, int[] parent) {
        if (parent[i] != i)
            parent[i] = find(parent[i], parent);
        return parent[i];
    }
}

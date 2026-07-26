class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), left = 0, right = 0, leftIdx = -1, rightIdx = -1;

        HashMap<Character, Integer> fMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (char ch : t.toCharArray())
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

        while (right < m) {
            char ch = s.charAt(right);

            fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
            if (right - left + 1 < n) {
                right++;
                continue;
            }

            while (isValid(fMap, sMap)) {
                if(leftIdx==-1 || right-left+1 < rightIdx-leftIdx+1){
                leftIdx = left;
                rightIdx = right;
                }
                char leftCh = s.charAt(left);
                fMap.put(leftCh, fMap.get(leftCh) - 1);
                left++;
            }

            right++;
        }

        if (leftIdx == -1)
            return "";

        return s.substring(leftIdx, rightIdx + 1);
    }

    public boolean isValid(HashMap<Character, Integer> fMap, HashMap<Character, Integer> sMap) {

        for (char ch : sMap.keySet()) {
            if (!fMap.containsKey(ch) || sMap.get(ch) > fMap.get(ch))
                return false;
        }

        return true;
    }
}
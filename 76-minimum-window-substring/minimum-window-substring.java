class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), left = 0, right = 0, leftIdx = -1, rightIdx = -1, required = 0, formed = 0;

        HashMap<Character, Integer> fMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            if (!sMap.containsKey(ch))
                required++;
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        while (right < m) {
            char ch = s.charAt(right);

            fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);

            if (sMap.containsKey(ch) && fMap.get(ch).intValue() == sMap.get(ch).intValue())
                formed++;

            if (right - left + 1 < n) {
                right++;
                continue;
            }

            while (formed == required) {
                if (leftIdx == -1 || right - left + 1 < rightIdx - leftIdx + 1) {
                    leftIdx = left;
                    rightIdx = right;
                }
                char leftCh = s.charAt(left);

                if (sMap.containsKey(leftCh)
                        && fMap.get(leftCh).intValue() == sMap.get(leftCh).intValue())
                    formed--;

                fMap.put(leftCh, fMap.get(leftCh) - 1);
                left++;
            }

            right++;
        }

        if (leftIdx == -1)
            return "";

        return s.substring(leftIdx, rightIdx + 1);
    }
}
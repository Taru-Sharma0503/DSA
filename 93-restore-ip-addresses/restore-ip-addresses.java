class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        getIp(0, 0, s, new StringBuilder());
        return ans;
    }

    public void getIp(int dots, int idx, String s, StringBuilder temp) {
        if (dots == 4) {
            if (idx == s.length()) {
                temp.setLength(temp.length() - 1);
                ans.add(temp.toString());
            }
        }

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String part = s.substring(idx, idx + i);
            if (part.startsWith("0") && part.length() > 1) {
                break;
            }

            int len = temp.length();

            if (Integer.parseInt(part) <= 255) {
                temp.append(part).append(".");
                getIp(dots + 1, idx + i, s, temp);
                temp.setLength(len);
            }
        }
    }
}
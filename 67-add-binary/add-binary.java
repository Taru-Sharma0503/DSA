class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int len1 = a.length(), len2 = b.length(), idx1 = len1 - 1, idx2 = len2 - 1;
        char carry = '0', ch1, ch2, toAdd;

        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0)
                ch1 = a.charAt(idx1);
            else
                ch1 = '0';

            if (idx2 >= 0)
                ch2 = b.charAt(idx2);
            else
                ch2 = '0';

            if (ch1 == '1' && ch2 == '1' && carry == '0') {
                toAdd = '0';
                carry = '1';
            } else if (ch1 == '0' && ch2 == '0' && carry == '0') {
                toAdd = '0';
                carry = '0';
            } else if (carry == '0') {
                toAdd = '1';
                carry = '0';
            } else if (ch1 == '1' && ch2 == '1' && carry == '1') {
                toAdd = '1';
                carry = '1';
            } else if (ch1 == '0' && ch2 == '0' && carry == '1') {
                toAdd = '1';
                carry = '0';
            } else {
                toAdd = '0';
                carry = '1';
            }

            ans.insert(0, toAdd);
            idx1--;
            idx2--;
        }

        if (carry == '1')
            ans.insert(0, '1');

        return ans.toString();
    }
}
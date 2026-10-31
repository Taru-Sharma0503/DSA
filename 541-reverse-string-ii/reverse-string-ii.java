class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        char[] ans = new char[arr.length];

        boolean reverse = true;
        int idx = 0, len = s.length(), pos = 0;

        while (idx < len) {
            if (reverse) {
                char[] reversed = reverse(arr, idx, idx + k - 1);
                for (char ch : reversed)
                    ans[pos++] = ch;
            } else {
                char[] notReversed = noreverse(arr, idx, idx + k - 1);
                for (char ch : notReversed)
                    ans[pos++] = ch;
            }

            reverse = !reverse;
            idx = idx + k;
        }

        return new String(ans);
    }

    public char[] reverse(char[] arr, int i, int j) {
        if (j >= arr.length)
            j = arr.length - 1;

        char[] reversed = new char[j - i + 1];

        int pos = 0;
        for (int idx = j; idx >= i; idx--)
            reversed[pos++] = arr[idx];

        return reversed;
    }

    public char[] noreverse(char[] arr, int i, int j) {
        if (j >= arr.length)
            j = arr.length - 1;

        char[] notreversed = new char[j - i + 1];

        int pos = 0;
        for (int idx = i; idx <= j; idx++)
            notreversed[pos++] = arr[idx];

        return notreversed;
    }
}
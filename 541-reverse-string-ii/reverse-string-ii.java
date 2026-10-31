class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        boolean reverse = true;
        int idx = 0, len = s.length();

        while (idx < len) {
            if (reverse) {
                reverse(arr, idx, idx + k - 1);
            }

            reverse = !reverse;
            idx = idx + k;
        }

        return new String(arr);
    }

    public void reverse(char[] arr, int i, int j) {
        if (j >= arr.length)
            j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
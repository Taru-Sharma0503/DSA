class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        int s = 0, e = 0, sum = code[0];

        if (k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }

        int count = 0;
        int size = 1;
        while (count < n) {
            if (size < Math.abs(k)) {
                e = (e + 1) % n;
                sum += code[e];
                size++;
            } else if (size == Math.abs(k)) {
                if (k > 0)
                    ans[(s - 1 + n) % n] = sum;
                else
                    ans[(e + 1) % n] = sum;
                count++;
                sum -= code[s];
                s = (s + 1) % n;
                e = (e + 1) % n;
                sum += code[e];
            }
        }

        return ans;
    }
}
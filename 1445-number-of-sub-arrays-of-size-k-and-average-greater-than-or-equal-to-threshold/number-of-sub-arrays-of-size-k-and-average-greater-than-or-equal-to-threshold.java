class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length, sum = 0, left = 0, right = 0, ans = 0;
        double avg;

        while (right < n) {
            sum += arr[right];
            if (right - left + 1 > k) {
                sum -= arr[left];
                left++;
            }
            avg = (double) sum / k;
            if (right - left + 1 == k && avg >= (double) threshold)
                ans++;
            right++;
        }

        return ans;
    }
}
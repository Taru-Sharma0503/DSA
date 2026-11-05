class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for (int num1 : arr1) {
            if (valid(arr2, num1, d))
                ans++;
        }

        return ans;
    }

    public boolean valid(int[] arr2, int num1,int d) {
        for (int num2 : arr2) {
            if (Math.abs(num2 - num1) <= d)
                return false;
        }

        return true;
    }
}
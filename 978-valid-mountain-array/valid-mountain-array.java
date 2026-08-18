class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        boolean increasing = true;

        if (n < 3 || arr[0]>arr[1])
            return false;

        for (int i = 0; i < n - 1; i++) {
            if (increasing && arr[i] < arr[i + 1] || !increasing && arr[i] > arr[i + 1])
                continue;

            if (increasing && arr[i] > arr[i + 1]){
                increasing = false;
            }
            else
                return false;
        }

        if(!increasing)
            return true;
        return false;
    }
}
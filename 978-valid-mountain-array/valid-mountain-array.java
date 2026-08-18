class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length,flag=0;
        boolean increasing = true;

        if (n < 3 || arr[0]>arr[1])
            return false;

        for (int i = 0; i < n - 1; i++) {
            if (increasing && arr[i] < arr[i + 1] || !increasing && arr[i] > arr[i + 1])
                continue;

            if (increasing && arr[i] > arr[i + 1]){
                flag=1;
                increasing = false;
            }
            else
                return false;
        }

        if(flag==1)
            return true;
        return false;
    }
}
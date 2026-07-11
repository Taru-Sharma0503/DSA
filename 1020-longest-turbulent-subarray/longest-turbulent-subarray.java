class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, left = 0, right = 1, ans = 1;
        boolean greater;

        if (n == 1)
            return 1;

        while(right<n && arr[right]==arr[right-1]){
            right++;
        }

        left=right-1;
        if (left+1<n && arr[left] > arr[left+1])
            greater = true;
        else
            greater = false;

        while (right < n - 1) {
             if (greater && arr[right] < arr[right + 1]) {
                greater = !greater;
            } else if (!greater && arr[right] > arr[right + 1]) {
                greater = !greater;
            } else {
                ans = Math.max(ans, right - left + 1);
                while (right < n - 1 && arr[right] == arr[right + 1])
                    right++;
                if (right == n - 1)
                    break;
                left = right;
                if (arr[left] > arr[left + 1])
                    greater = true;
                else
                    greater = false;
            }
            right++;
        }
        
        if(left==n-1)
            return ans;
        
        ans = Math.max(ans, right - left + 1);
        return ans;
    }
}
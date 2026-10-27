class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, s = 0, e = n - 1, idx = n - 1;
        int ans[] = new int[n];

        while (s <= e) {
            int firstEle = nums[s] * nums[s];
            int lastEle = nums[e] * nums[e];

            if (firstEle == lastEle) {
                ans[idx--] = firstEle;
                if (idx < 0)
                    break;
                ans[idx--] = lastEle;
                s++;
                e--;
            }

            else if (firstEle < lastEle) {
                ans[idx--] = lastEle;
                e--;
            }

            else {
                ans[idx--] = firstEle;
                s++;
            }
        }

        return ans;
    }
}
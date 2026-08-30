class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0, maxIdx = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx])
                minIdx = i;
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        int idx1 = Math.min(minIdx, maxIdx);
        int idx2 = Math.max(minIdx, maxIdx);

        int deletion1 = (idx1 + 1) + (n - idx2);

        return Math.min(deletion1, Math.min(idx2 + 1, n - idx1));
    }
}
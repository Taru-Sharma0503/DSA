class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length, minOdd = Integer.MAX_VALUE;
        boolean makingOdd;

        for (int num : nums1) {
            if (num % 2 != 0 && num < minOdd)
                minOdd = num;
        }

        makingOdd = true;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0 || nums1[i] > minOdd)
                continue;

            else {
                makingOdd = false;
                break;
            }
        }

        if (makingOdd)
            return true;

        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0 || nums1[i] > minOdd)
                continue;

            return false;
        }

        return true;
    }
}
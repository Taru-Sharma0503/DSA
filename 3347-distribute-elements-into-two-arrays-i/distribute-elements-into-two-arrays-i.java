class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length, idx = 0;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1))
                arr1.add(nums[i]);
            else
                arr2.add(nums[i]);
        }

        for (int num : arr1)
            nums[idx++] = num;

        for (int num : arr2)
            nums[idx++] = num;

        return nums;
    }
}
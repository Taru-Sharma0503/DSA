class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int isPresentinNums1[] = new int[1001];
        List<Integer> ans = new ArrayList<>();

        for (int num : nums1)
            isPresentinNums1[num]++;

        for (int num : nums2) {
            if (isPresentinNums1[num]>=1) {
                ans.add(num);
                isPresentinNums1[num]--;
            }
        }

        int arr[] = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++)
            arr[i] = ans.get(i);

        return arr;
    }
}
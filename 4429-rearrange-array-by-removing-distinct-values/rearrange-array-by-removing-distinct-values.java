class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[n];
        int idx = -1;

        for (int num : nums)
            list.add(num);

        while (!list.isEmpty()) {
            for (int num : list) {
                set.add(num);
            }

            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                Integer ele = it.next();
                ans[++idx] = ele;
                list.remove(ele);
            }
            set.clear();
        }

        return ans;
    }
}
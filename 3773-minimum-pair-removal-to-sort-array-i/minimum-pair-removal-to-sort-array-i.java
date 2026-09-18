class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (int num : nums) {
            list.add(num);
        }

        while (!isSorted(list)) {
            int idx = findMinSum(list);
            int sum = list.get(idx) + list.get(idx + 1);

            list.remove(idx + 1);
            list.remove(idx);
            list.add(idx, sum);
            ans++;
        }

        return ans;
    }

    boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }

        return true;
    }

    int findMinSum(List<Integer> list) {
        int sum = Integer.MAX_VALUE, idx = -1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + list.get(i + 1) < sum) {
                sum = list.get(i) + list.get(i + 1);
                idx = i;
            }
        }

        return idx;
    }
}
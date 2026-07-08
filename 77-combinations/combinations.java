class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combination(1, n, k, new ArrayList<>());
        return ans;
    }

    public void combination(int num, int n, int k, List<Integer> curr) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (num > n || n - num + 1 < k - curr.size())
            return;

        curr.add(num);
        combination(num + 1, n, k, curr);
        curr.remove(curr.size() - 1);
        combination(num + 1, n, k, curr);
    }
}
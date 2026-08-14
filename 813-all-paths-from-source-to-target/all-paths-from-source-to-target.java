class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> temp=new ArrayList<>();

        temp.add(0);
        findPath(0, graph.length - 1, graph, temp);
        return ans;
    }

    public void findPath(int src, int target, int[][] graph, List<Integer> temp) {

        if (src == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int nbr : graph[src]) {
            temp.add(nbr);
            findPath(nbr, target, graph, temp);
            temp.removeLast();
        }
    }
}
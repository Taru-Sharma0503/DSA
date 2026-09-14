/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Node ans = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        map.put(node, ans);

        queue.add(node);
        while (!queue.isEmpty()) {
            List<Node> neighbours = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node qNode = queue.poll();

                for (Node nbrs : qNode.neighbors) {
                    if (!map.containsKey(nbrs)) {
                        map.put(nbrs, new Node(nbrs.val));
                        queue.add(nbrs);
                    }

                    map.get(qNode).neighbors.add(map.get(nbrs));
                }
                }
            }
            return ans;
        }
}
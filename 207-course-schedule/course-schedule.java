class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<Integer> graph[] = new ArrayList[numCourses];
        ArrayList<Integer> order = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        int idx = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int parent = queue.removeFirst();
            order.add(parent);
            for (int nbr : graph[parent]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0)
                    queue.add(nbr);
            }
        }

        return order.size() == numCourses ? true : false;
    }
}
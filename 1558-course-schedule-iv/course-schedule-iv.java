class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = prerequisites.length;
        List<Integer> graph[] = new ArrayList[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        int idx = 0;
        HashMap<Integer,Set<Integer>> map=new HashMap<>();

        for(int i=0;i<numCourses;i++)
            map.put(i,new HashSet<>()); 

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
            indegree[pair[1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int parent = queue.removeFirst();
            for (int nbr : graph[parent]) {
                map.get(nbr).add(parent);
                map.get(nbr).addAll(map.get(parent));
                indegree[nbr]--;
                if (indegree[nbr] == 0)
                    queue.add(nbr);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            ans.add(map.get(v).contains(u));
        }

        return ans;
    }

    public boolean appearsBefore(List<Integer> order, int u, int v) {
        boolean ufound = false;

        for (int num : order) {
            if (num == u) {
                ufound = true;
            }
            if (num == v) {
                if (ufound)
                    return true;
                else
                    return false;
            }
        }

        return false;
    }
}
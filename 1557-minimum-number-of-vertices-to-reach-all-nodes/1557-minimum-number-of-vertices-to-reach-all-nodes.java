class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int indegree[] = new int[n];

        // Calculate indegree
        for(int i = 0; i < edges.size(); i++) {
            int dest = edges.get(i).get(1);

            indegree[dest]++;
        }

        // Find nodes having indegree 0
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
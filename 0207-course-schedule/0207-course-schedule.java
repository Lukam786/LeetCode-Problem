class Solution {
    public  boolean dfs(int src,boolean vis[], List<List<Integer>> adj, Set<Integer> topoSort){
        if(vis[src]==true){
            if(topoSort.contains(src)) return false;
            else return true;
        }
        vis[src]=true;

        for(int nbr:adj.get(src)){
            boolean cycle=dfs(nbr,vis,adj,topoSort);
            if(cycle==true) return true;
        }
        topoSort.add(src);
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] edge: prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }
         Set<Integer> topoSort=new LinkedHashSet<>();
        boolean[] vis= new boolean[numCourses];
        for(int src=0; src<numCourses; src++){
            if(vis[src]==false){
                boolean cycle=dfs(src,vis,adj,topoSort);
                if(cycle==true) return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean dfs(List<List<Integer>> adj,int curr,boolean vis[],Set<Integer> topoSort){
        if(vis[curr]==true){
            if(topoSort.contains(curr)) return false;
            else return true;
        }
        vis[curr]=true;
        for(int neighbour:adj.get(curr)){
            boolean cycle=dfs(adj,neighbour,vis,topoSort);
            if(cycle==true) return true;
        }
        topoSort.add(curr);
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Lookman mansuri.....;
        boolean vis[]=new boolean[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
         for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj.get(b).add(a);
        }
          Set<Integer> topoSort=new LinkedHashSet<>();
         for(int i=0; i<numCourses; i++){
            if(vis[i]==false){
                boolean cycle=dfs(adj,i,vis,topoSort);
                if(cycle==true){
                    return false;
                }
            }
         }
         return true;
    }
}
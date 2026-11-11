class Solution {
    public void dfs(int[][] graph,int src, int target,List<List<Integer>> result,List<Integer> path){
        path.add(src);
        if(src==target){
            result.add(new ArrayList<>(path));
        }
        else {
            for(int neighbour: graph[src]){
                dfs(graph,neighbour,target,result,path);
            }
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        int src=0;
        int target=graph.length-1;
        dfs(graph,src,target,result,path);
        return result;
    }
}
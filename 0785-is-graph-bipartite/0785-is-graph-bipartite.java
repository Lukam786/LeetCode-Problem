class Solution {
    public boolean checkUsingBfs(int[][] graph,int curr,int col[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        col[curr]=0;
        while(!q.isEmpty()){
            int src=q.remove();
            int currColor=col[src];
            for(int neighbour:graph[src]){
                if(col[neighbour]==-1){
                    col[neighbour]=1-currColor;
                    q.add(neighbour);
                }
                else{
                    if(currColor==col[neighbour]){
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        for(int i=0; i<n; i++){
            col[i]=-1;
        }
        for(int i=0; i<n; i++){
            if(col[i]==-1){
                boolean result=checkUsingBfs(graph,i,col);
                if(result==false){
                    return false;
                }
            }
        }
        return true;
    }
}
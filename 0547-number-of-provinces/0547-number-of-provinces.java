class Solution {
    public void bfsUtil(int[][] isConnected,int curr, boolean vis[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        vis[curr]=true;
        while(!q.isEmpty()){
            int src=q.remove();
          for(int i=0; i<isConnected.length; i++){
            if(isConnected[src][i]==1 && !vis[i]){
                vis[i]=true;
                q.add(i);
            }
          }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                count++;
                bfsUtil(isConnected,i,vis);
            }
        }
        return count;
    }
}
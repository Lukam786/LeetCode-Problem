class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int neighbour: rooms.get(curr)){
               if(!vis[neighbour]){
                vis[neighbour]=true;
                q.add(neighbour);
               }
            }
        }
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}
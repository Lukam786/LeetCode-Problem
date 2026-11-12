//Lookman Mansuri.........
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
             adj.get(b).add(a);
             indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);
            for(int neighbour: adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        if(ans.size()==numCourses){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int indegree[]=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(q.isEmpty()==false){
            int curr=q.remove();
            ans.add(curr);

            for(int conn: adj.get(curr)){
                indegree[conn]--;
                if(indegree[conn]==0){
                    q.add(conn);
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
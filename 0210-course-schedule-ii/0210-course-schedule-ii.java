//Lookman Mansuri......;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int result[]=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            result[index]=curr;
            index++;
           for(int neighbour: adj.get(curr)){
                 indegree[neighbour]--;
                 if(indegree[neighbour]==0){
                    q.add(neighbour);
                 }
           }
        }
        if(index==numCourses){
            return result;
        }
        else{
            return new int[0];
        }
    }
}
class Solution {
    int parent[];
    int weight[];
    public int findParent(int n){
        if(n==parent[n]){
            return n;
        }
        parent[n]=findParent(parent[n]);
        return parent[n];
    }
    public void unionBySize(int node1, int node2){
        int originalParent1=findParent(node1);
        int originalParent2=findParent(node2);
        
        if(originalParent1==originalParent2){
            return;
        }
        if(weight[originalParent1]>weight[originalParent2]){
            parent[originalParent2]=originalParent1;
            weight[originalParent1]+=weight[originalParent2];
        }
        else{
            parent[originalParent1]=originalParent2;
            weight[originalParent2]+=weight[originalParent1];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        weight=new int[n+1];
        for(int i=0 ; i<=n; i++){
            parent[i]=i;
            weight[i]=1;
        }
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];

            int parent1=findParent(u);
            int parent2=findParent(v);
            if(parent1==parent2){
                return edges[i];
            }
            unionBySize(u,v);
        }
        return new int[0];
    }
}
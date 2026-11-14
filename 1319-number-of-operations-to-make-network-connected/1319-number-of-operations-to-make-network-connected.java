class Solution {
    int parent[];
    int size[];
      public int findParent(int n){
        if(n==parent[n]){
            return n;
        }
        parent[n]=findParent(parent[n]);
        return parent[n];
      }
      public boolean unionBySize(int nodes1, int nodes2){
        int parent1=findParent(nodes1);
        int parent2=findParent(nodes2);
        if(parent1==parent2){
            return false;
        }
        if(size[parent1]>size[parent2]){
            parent[parent2]=parent1;
            size[parent1]+=size[parent2];
        }
        else{
            parent[parent1]=parent2;
            size[parent2]+=size[parent1];
        }
        return true;
      }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        parent=new int[n];
        size=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        int component=n;
        for(int i=0; i<connections.length; i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(unionBySize(u,v)){
                component--;
            }
        }
        return component-1;
    }
}
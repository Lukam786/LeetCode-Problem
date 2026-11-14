
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

    public void unionBySize(int node1,int node2){
        int parent1=findParent(node1);
        int parent2=findParent(node2);

        if(parent1==parent2){
            return;
        }

        if(size[parent1]>size[parent2]){
            parent[parent2]=parent1;
            size[parent1]+=size[parent2];
        }
        else{
            parent[parent1]=parent2;
            size[parent2]+=size[parent1];
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;

        parent=new int[n];
        size=new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1){
                    unionBySize(i,j);
                }
            }
        }

        int count=0;

        for(int i=0; i<n; i++){
            if(findParent(i)==i){
                count++;
            }
        }

        return count;
    }
}

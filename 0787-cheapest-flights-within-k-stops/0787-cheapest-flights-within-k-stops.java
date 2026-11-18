class Solution {
    static class Edges{
    int src;
    int dest;
    int wt;
    Edges(int src, int dest, int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
    }
    static class Info{
        int v;
        int cost;
        int stop;
        Info(int v, int cost, int stop){
            this.v=v;
            this.cost=cost;
            this.stop=stop;
        }
    }
    public static void createGraph(ArrayList<Edges> graph[],int[][] flights){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];

            Edges e=new Edges(src,dest,wt);
            graph[src].add(e);
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edges> graph[]=new ArrayList[n];
        int dist[]=new int[n];
        for(int i=0; i<dist.length; i++){
            if(src!=i){
            dist[i]=Integer.MAX_VALUE;
            }
        }
        createGraph(graph,flights);
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr=q.remove();

            if(curr.stop>k){
                continue;
            }
            for(int i=0; i<graph[curr.v].size(); i++){
                Edges e=graph[curr.v].get(i);

                int u=e.src;
                int vt=e.dest;
                int w=e.wt;

                if(curr.cost+w<dist[vt]){
                    dist[vt]=curr.cost+w;
                    q.add(new Info(vt,curr.cost+w,curr.stop+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dst];
        }
    }
}
class Solution {
    static class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row,int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int maxTime=0;
        Queue<Triplet> q=new LinkedList<>();
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
               if(grid[row][col]==2){
                q.add(new Triplet(row,col,0));
               }
               else if(grid[row][col]==1){
                fresh++;
               }
            }
        }
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!q.isEmpty()){
            Triplet t=q.remove();
            for(int i=0; i<dr.length; i++){
                int row=t.row+dr[i];
                int col=t.col+dc[i];
                if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1){
                    q.add(new Triplet(row,col,t.time+1));
                    maxTime=t.time+1;
                    grid[row][col]=2;
                    fresh--;
                }
            }
        }
        if(fresh>0){
            return -1;
        }
        else{
            return maxTime;
        }
    }
}
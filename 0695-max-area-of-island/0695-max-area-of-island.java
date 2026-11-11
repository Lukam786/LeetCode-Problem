class Solution {
    int n=0;
    int m=0;
    public int dfs(int[][] grid,int i, int j){
        if(i<0||i>=n|| j<0||j>=m){
            return 0;
        }
        if(grid[i][j]==0|| grid[i][j]==2){
            return 0;
        }
        grid[i][j]=2;
      int up=  dfs(grid,i-1,j);
        int right=dfs(grid,i,j+1);
       int left= dfs(grid,i,j-1);
        int down=dfs(grid,i+1,j);

        return 1+up+right+left+down;
    }
    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                  int area=  dfs(grid,i,j);
                  max=Math.max(max,area);
                }
            }
        }
        return max;
    }
}
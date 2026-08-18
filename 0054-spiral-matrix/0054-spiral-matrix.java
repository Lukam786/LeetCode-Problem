class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int sr=0, sc=0 , er=n-1, ec=m-1;
        while(sr<=er && sc<=ec){
            int row=sr;
            for(int col=sc; col<=ec; col++){
                ans.add(matrix[row][col]);
            }
            sr++;
            int col=ec;
            for(row=sr; row<=er; row++){
             ans.add(matrix[row][col]);
            }
            ec--;
            row=er;
            if(sr<=er){
           for( col=ec; col>=sc; col--){
                ans.add(matrix[row][col]);
            }
            er--;
            }
            if(sc<=ec){
                 col=sc;
                for( row=er; row>=sr; row--){
                    ans.add(matrix[row][col]);
                }
                sc++;
            }
           
        }
        return ans;
        
    }
}
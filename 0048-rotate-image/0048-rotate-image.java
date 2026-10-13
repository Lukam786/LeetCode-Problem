class Solution {
    public void rotate(int[][] matrix) {
        int row=0;
        while(row<matrix.length){
            for(int i=row; i<matrix.length; i++){
                int temp=matrix[row][i];
                matrix[row][i]=matrix[i][row];
                matrix[i][row]=temp;
            }
            row++;
        }
       for(int r=0; r<matrix.length; r++){
        int left=0;
        for(int i=matrix.length-1; i>=left; i--){
           int temp=matrix[r][left];
           matrix[r][left]=matrix[r][i];
           matrix[r][i]=temp;
           left++;
        }
       }
    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int maxArea=0;
        int heights[]=new int[cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
            int currArea=largestRectangleArea(heights);
             maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        int nsr[]=new int[n];
        int nsl[]=new int[n];
        Stack<Integer> s=new Stack<>();
        // next smallest right...
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
         s.clear();
        // next smallest left...
        for(int i=0; i<n; i++){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0; i<n; i++){
            int height=heights[i];
            int width=nsr[i]-nsl[i]-1;
            int currarea=width*height;
            maxArea=Math.max(currarea,maxArea);
        }
        return maxArea;
    }
}
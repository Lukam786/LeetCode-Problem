class Solution {
    public int maxDepth(String s) {
        int parentheses=0;
        int maxdepth=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                parentheses++;
                maxdepth= Math.max(parentheses,maxdepth);
            }
          else if(ch==')'){
                parentheses--;
            }
        }
        return maxdepth;
    }
}
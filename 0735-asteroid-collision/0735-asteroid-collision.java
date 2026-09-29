class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0; i<n; i++){
           int a=asteroids[i];
           while(!st.isEmpty()&& a<0 && st.peek()>0){
            int sum=a+st.peek();
            if(sum<0){
                st.pop();
            }
            else if(sum>0){
                a=0;
            }
            else{
                st.pop();
                a=0;
            }
           }
           if(a!=0){
            st.push(a);
           }
        }
        int s=st.size();
        int ans[]=new int[s];
        int i=s-1;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
}
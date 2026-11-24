class Solution {
    public int db(int n, int arr[]){
        if(n==0|| n==1){
            return n;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        return arr[n]=db(n-1,arr)+db(n-2,arr);
    }
    public int fib(int n) {
        int arr[]=new int[n+1];
        return db(n,arr);
    }
}
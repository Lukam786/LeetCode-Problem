class Solution {
    public int dp(int arr[], int n){
        if(n==1|| n==2){
            return n;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        return arr[n] = dp(arr, n-1) + dp(arr, n-2);
    }
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        return dp(arr, n);
    }
}
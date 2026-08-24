class Solution {
    public List<Integer> grayCode(int n) {
    List<Integer> ans = new ArrayList<>();
    int size=1<<n;
    for( int i=0;i<size; i++){
        int graycode=(i^(i>>1));
        ans.add(graycode);
    }
        return ans;
    }
}
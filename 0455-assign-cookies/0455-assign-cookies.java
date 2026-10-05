class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int left=0;
        int right=0;
        int count=0;
        while(left<s.length && right< g.length){
            if(s[left]>=g[right]){
                left++;
                right++;
                count++;
            }
            else{
                left++;
            }
        }
        return count;
    }
}
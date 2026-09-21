class Solution {
    public int longestPalindrome(String s) {
        int[] freq =new int[128];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)]++;
        }
        int ans=0;
        boolean oddfound=false;
        for(int i=0; i<freq.length; i++){
            if(freq[i]%2==0){
                ans+=freq[i];
            }
            else{
                ans+= freq[i]-1;
                oddfound=true;
            }
        }
        if(oddfound){
            ans++;
        }
        return ans;
        
    }
}
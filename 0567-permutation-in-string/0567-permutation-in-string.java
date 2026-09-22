class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count=new int[26];
        int[] s2Count=new int[26];
        for(int i=0; i<s1.length(); i++){
            s1Count[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<s2.length(); i++){
            s2Count[s2.charAt(i)-'a']++;
            
            if(i>=s1.length()){
                s2Count[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }
        return false;
        
    }
}
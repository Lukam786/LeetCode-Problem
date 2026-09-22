class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sCount=new int[26];
        int[]  pCount=new int[26];
        ArrayList<Integer> result=new ArrayList<>();
       for(int i=0; i<p.length(); i++){
          pCount[p.charAt(i)-'a']++;
       }
       for(int i=0; i<s.length(); i++){
           sCount[s.charAt(i)-'a']++;
           
           if(i>=p.length()){
            sCount[s.charAt(i-p.length())-'a']--;
           }

           if(Arrays.equals(sCount,pCount)){
            result.add(i-p.length()+1);
           }
       }
        return result;
    }
}
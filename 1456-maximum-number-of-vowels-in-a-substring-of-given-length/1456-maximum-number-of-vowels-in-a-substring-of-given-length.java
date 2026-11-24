class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels=0;
        int windowVowels=0;
        HashSet<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i=0; i<k; i++){
            if(set.contains(s.charAt(i))){
                windowVowels++;
            }
            maxVowels=windowVowels;
        }

        for(int i=k; i<s.length(); i++){
            if(set.contains(s.charAt(i-k))){
                windowVowels--;
            }
            if(set.contains(s.charAt(i))){
                windowVowels++;
                 
            }
            maxVowels=Math.max(maxVowels,  windowVowels);
           
        }
        return maxVowels;
    }
}
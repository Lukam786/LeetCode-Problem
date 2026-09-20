class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set= new HashSet<>();
        if(pattern.length()!=words.length){
            return false;
        }
        for(int i=0; i<pattern.length(); i++){
            char c1=pattern.charAt(i);
            String word=words[i];
            if(map.containsKey(c1)){
                if(!map.get(c1).equals(word)){
                    return false;
                }
            }
            else {
                if(set.contains(word)){
                    return false;
                }
                map.put(c1,word);
                set.add(word);
            }
        }
        return true;
    }
}
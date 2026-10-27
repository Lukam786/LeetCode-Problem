class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String st=strs[i];
            char[] charArray=st.toCharArray();
            Arrays.sort(charArray);
            String s2=new String(charArray);
            if(map.containsKey(s2)){
                map.get(s2).add(st);
            }
            else{
                map.put(s2,new ArrayList<String>());
                map.get(s2).add(st);
            }
        }
        for(List<String>v: map.values()){
            ans.add(v);
        }
        return ans;
        
    }
}
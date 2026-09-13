class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String>result=new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        backtrack(digits,0,"",result);
        return result;  
    }
    public void backtrack(String digits,int index,String curr,List<String>result){
        if(index==digits.length()){
            result.add(curr);
            return;
        }
        int digit=digits.charAt(index)-'0';
        String letters=map[digit];
        for(int i=0; i<letters.length(); i++){
            char ch=letters.charAt(i);
            backtrack(digits,index+1, curr+ch,result);
        }
    }
}
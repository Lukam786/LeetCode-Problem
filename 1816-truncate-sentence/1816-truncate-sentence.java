class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb=new StringBuilder("");
        int count=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch==' '){
                count++;
            }
            
              if(count == k){
                break;
            }
            sb.append(ch);
           
        }
        return sb.toString();
    }
}
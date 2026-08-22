class Solution {
    public int compress(char[] chars) {
        int i=0;
        int write=0;
        while(i<chars.length){
            int count=1;
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            chars[write]=chars[i];
            write++;
            if(count>1){
              String  CountStr= String.valueOf(count);
              for(int j=0; j<CountStr.length(); j++){
                chars[write]=CountStr.charAt(j);
                write++;
              }
            }
            i++;
        }
        return write;
    }
}
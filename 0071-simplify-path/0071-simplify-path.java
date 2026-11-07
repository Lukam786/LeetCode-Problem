class Solution {
    public String simplifyPath(String path) {
        String[] paths=path.split("/");
        Stack<String>s=new Stack<>();
        for(int i=0; i<paths.length;  i++){
            String curr=paths[i];
            if(curr.equals("..")){
                if(s.size()>0) s.pop();
            }
            else if(curr.equals(".")||curr.equals("")){

            }
        else{
            s.push(curr);
        }
        }
    StringBuilder sb=new StringBuilder();
    while(s.size()>0){
        sb.insert(0,"/" + s.pop());
    }
    if(sb.length()==0) return "/";
    return sb.toString();
}
}
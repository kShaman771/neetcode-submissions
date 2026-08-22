class Solution {
    public String simplifyPath(String path) {
        Stack<String> s=new Stack<>();
        String[] st=path.split("/");
        for(String part:st){
            if(part.equals("")||part.equals(".")){
                continue;
            }
            else if(part.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else{
                s.push(part);
            }
        }

        StringBuilder res=new StringBuilder();
        for(String stri:s){
            res.append("/").append(stri);

        }
        return res.length()==0?"/":res.toString();
        
        
    }
}
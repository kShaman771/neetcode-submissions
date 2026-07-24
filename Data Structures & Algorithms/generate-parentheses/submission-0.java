class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        dfs(0,0,n,new StringBuilder(),result);
        return result;
    }
    private void dfs(int open,int closed,int n,StringBuilder current,List<String> result){
        if(open==n && closed==n){
            result.add(current.toString());
            return;
        }

        if(open<n){
            current.append("(");
            dfs(open+1,closed,n,current,result);
            current.deleteCharAt(current.length()-1);
        }
        if(closed<open){
            current.append(")");
            dfs(open,closed+1,n,current,result);
            current.deleteCharAt(current.length()-1);
        }
    }
}

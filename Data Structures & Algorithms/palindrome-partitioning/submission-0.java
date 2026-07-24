class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        dfs(0,s,new ArrayList<>(),result);
        return result;
    }
    private void dfs(int start,String s, List<String> current,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                current.add(s.substring(start,end+1));
                dfs(end+1,s,current,result);
                current.remove(current.size()-1);
            }

        }
    }

    boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

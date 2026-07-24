class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        String[] wordmap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(0,wordmap,digits,new StringBuilder(),result);
        return result;
    }
    private void dfs(int index,String[] wordmap,String digits,StringBuilder current,List<String> result){
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }
        String letter=wordmap[digits.charAt(index)-'0'];
        for(char c:letter.toCharArray()){
            current.append(c);
            dfs(index+1,wordmap,digits,current,result);
            current.deleteCharAt(current.length()-1);
        }
    }
}

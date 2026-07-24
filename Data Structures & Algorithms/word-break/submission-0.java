class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[s.length()]=true;
        for(int i=s.length()-1;i>=0;i--){
            for(String word:set){
                if(i+word.length()<=s.length() && s.startsWith(word,i)){
                    dp[i]=dp[i+word.length()];
                
                if(dp[i]){
                    break;
                }
                }

            }
        }
        return dp[0];
        
    }
}

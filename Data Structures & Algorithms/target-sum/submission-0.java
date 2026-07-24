class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        if(Math.abs(target)>total){
            return 0;
        }
        if((total+target)%2!=0){
            return 0;
        }
        int subsetSum=(total+target)/2;

        int[] dp=new int[subsetSum+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=subsetSum;i>=num;i--){
                dp[i]+=dp[i-num];
            }
        }
        return dp[subsetSum];
    }
}

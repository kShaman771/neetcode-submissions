class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int right=1;
        int result=0;
        while(right<prices.length){
            if(prices[right]<prices[left]){
                left=right;
            }
            else{
                int profit=prices[right]-prices[left];
                result=Math.max(profit,result);
            }
            right++;
        }

        return result;
    }
}

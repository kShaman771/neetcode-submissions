class Solution {
    public int maxProfit(int[] prices) {
        int left =0;
        int right=0;
        int profit=0;
        while(right<prices.length){
            if(prices[right]<prices[left]){
                left=right;
                continue;
            }
            profit=Math.max(profit,prices[right]-prices[left]);
            right++;
            
        }
        return profit;
        
    }
}

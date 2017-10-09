//动态规划的思想
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length == 1){
            return 0;
        }
        int low = prices[0];
        int diff = 0;
        for(int i =1;i<prices.length;i++){
            diff = Math.max(diff,prices[i]-low);
            low  = Math.min(low,prices[i]);
        }
        return diff;
    }
}
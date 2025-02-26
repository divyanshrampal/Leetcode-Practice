class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        int buyDay = 0;
        int sellDay = 1;

        while(sellDay < prices.length){
            if(prices[buyDay] < prices[sellDay]){
                int currentProfit = prices[sellDay] - prices[buyDay];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
            else{
                buyDay = sellDay;
            }

            sellDay++;

        }

        return maxProfit;
        
    }
}
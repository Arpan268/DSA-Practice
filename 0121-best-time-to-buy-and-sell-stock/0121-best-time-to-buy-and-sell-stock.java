class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int currentprofit = 0, maxprofit = 0;

        for(int i = 0; i<prices.length; i++) {
            if(prices[i] < min) min = prices[i];

            currentprofit = prices[i]-min;
            if(currentprofit>maxprofit) maxprofit = currentprofit;
        }

        return maxprofit;
    }
}
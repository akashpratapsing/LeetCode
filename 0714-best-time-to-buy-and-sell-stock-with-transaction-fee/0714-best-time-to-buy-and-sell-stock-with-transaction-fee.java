class Solution {
    public int maxProfit(int[] prices, int fee) {

        int currBuy = 0, currNotBuy = 0, aheadBuy = 0, aheadNotBuy = 0;
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            currBuy = Math.max(-prices[ind] + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(prices[ind] - fee + aheadBuy, aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
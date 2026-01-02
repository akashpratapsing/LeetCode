class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[] after = new int[2];
        int[] curr = new int[2];

        for (int ind = prices.length - 1; ind >= 0; ind--) {
            curr[1] = Math.max(-prices[ind] + after[0],after[1]);
            curr[0] = Math.max(prices[ind] - fee + after[1],after[0]);
            after = curr;
        }
        return after[1];
    }
}
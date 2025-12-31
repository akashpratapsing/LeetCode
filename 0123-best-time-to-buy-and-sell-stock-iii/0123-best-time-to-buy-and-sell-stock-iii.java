class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions <= 2; transactions++) {

                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[ind] + after[0][transactions],
                                after[1][transactions]);
                    } else {
                        profit = Math.max(prices[ind] + after[1][transactions - 1],
                                after[0][transactions]);
                    }

                    curr[buy][transactions] = profit;
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}
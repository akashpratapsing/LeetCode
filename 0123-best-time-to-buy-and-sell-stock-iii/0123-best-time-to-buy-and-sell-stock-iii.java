class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions <= 2; transactions++) {

                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[ind] + dp[ind + 1][0][transactions],
                                dp[ind + 1][1][transactions]);
                    } else {
                        profit = Math.max(prices[ind] + dp[ind + 1][1][transactions - 1],
                                dp[ind + 1][0][transactions]);
                    }

                    dp[ind][buy][transactions] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
}
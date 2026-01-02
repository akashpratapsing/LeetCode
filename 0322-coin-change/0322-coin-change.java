class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = (i % coins[0] == 0) ? i / coins[0] : (int) 1e9;
        }

        for (int ind = 1; ind < n; ind++) {

            for (int t = 0; t <= amount; t++) {
                int notTake = dp[ind - 1][t];
                int take = (int) 1e9;
                if (coins[ind] <= t) {
                    take = 1 + dp[ind][t - coins[ind]];
                }
                dp[ind][t] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return (ans >= 1e9) ? -1 : ans;
    }
}

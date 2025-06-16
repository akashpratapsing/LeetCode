class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] >= 0) {
                    int coin = dp[i - coins[j]];
                    if (coin != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + coin);
                    }
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

}

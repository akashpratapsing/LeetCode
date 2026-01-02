class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            prev[i] = (i % coins[0] == 0) ? i / coins[0] : (int) 1e9;
        }

        for (int ind = 1; ind < n; ind++) {

            for (int t = 0; t <= amount; t++) {
                int notTake = prev[t];
                int take = (int) 1e9;
                if (coins[ind] <= t) {
                    take = 1 + curr[t - coins[ind]];
                }
                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return (ans >= 1e9) ? -1 : ans;
    }
}

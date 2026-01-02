class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans = f(coins, amount, n - 1, dp);
        return (ans >= 1e9) ? -1 : ans;
    }

    public int f(int[] coins, int t, int ind, int dp[][]){

        if (ind == 0) {
            if (t % coins[0] == 0) return t / coins[0];
            return (int) 1e9;
        }

        if (dp[ind][t] != -1) return dp[ind][t];

        int notTake = f(coins, t, ind - 1, dp);
        int take = (int) 1e9;
        if (coins[ind] <= t){
            take = 1 + f(coins, t - coins[ind], ind, dp);
        }
        return dp[ind][t] = Math.min(take, notTake);
    }

}

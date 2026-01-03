class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return f(coins, n - 1, amount, dp);
    }

    public int f(int[] arr, int ind, int target, int[][] dp){

        if (ind == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notTake = f(arr, ind - 1, target, dp);

        int take = 0;
        if (arr[ind] <= target){
            take = f(arr, ind, target - arr[ind], dp);
        }
        
        return dp[ind][target] = take + notTake;
    }
}
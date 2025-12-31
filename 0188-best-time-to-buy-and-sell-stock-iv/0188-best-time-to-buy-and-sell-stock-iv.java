class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] arrays : dp) {
            for (int[] array : arrays) {
                Arrays.fill(array, -1);
            }
        }
        return f(prices, 0, 1, k, dp);
    }

    public int f(int[] arr, int ind, int buy, int transactions, int[][][] dp) {

        if (transactions == 0)
            return 0;
        if (ind == arr.length)
            return 0;
        if (dp[ind][buy][transactions] != -1)
            return dp[ind][buy][transactions];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-arr[ind] + f(arr, ind + 1, 0, transactions, dp),
                    f(arr, ind + 1, 1, transactions, dp));
        } else {
            profit = Math.max(arr[ind] + f(arr, ind + 1, 1, transactions - 1, dp),
                    f(arr, ind + 1, 0, transactions, dp));
        }

        return dp[ind][buy][transactions] = profit;
    }
}
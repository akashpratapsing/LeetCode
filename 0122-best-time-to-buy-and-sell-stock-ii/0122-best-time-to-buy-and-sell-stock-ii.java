class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f(prices, 0, 1, dp);
    }

    public int f(int[] arr, int ind, int buy, int[][] dp){

        if (ind == arr.length) return 0;
        if (dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;

        if (buy == 1){
            profit = Math.max(
                -arr[ind] + f(arr, ind + 1, 0, dp),
                f(arr, ind + 1, 1, dp)
            );
        }else {
            profit = Math.max(
                arr[ind] + f(arr, ind + 1, 1, dp),
                f(arr, ind + 1, 0, dp)
            );
        }
        return dp[ind][buy] = profit;
    }
}
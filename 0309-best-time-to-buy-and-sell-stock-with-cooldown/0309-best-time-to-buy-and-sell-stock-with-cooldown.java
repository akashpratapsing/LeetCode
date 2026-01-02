class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f(prices, 0, 1, dp);
    }

    public int f(int[] arr, int ind, int buy, int[][] dp){

        if (ind >= arr.length) return 0;
        if (dp[ind][buy] != -1) return dp[ind][buy];

        if (buy == 1) {
            return dp[ind][buy] = Math.max(-arr[ind] + f(arr, ind + 1, 0, dp),
                            f(arr, ind + 1, 1, dp));
        }else {
            return dp[ind][buy] = Math.max(arr[ind] + f(arr, ind + 2, 1, dp),
                            f(arr, ind + 1, 0, dp));
        }
    }
}
class Solution {

    public int f(int i, int j, int[] cuts, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + f(i, k - 1, cuts, dp) + f(k + 1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;
        int[] cutsOrder = new int[m + 2];  
        cutsOrder[0] = 0;
        cutsOrder[m + 1] = n;

        for (int i = 0; i < m; i++) {
            cutsOrder[i + 1] = cuts[i];
        }

        Arrays.sort(cutsOrder);
        int[][] dp = new int[m + 2][m + 2];

        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cutsOrder[j + 1] - cutsOrder[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m];
    }
}
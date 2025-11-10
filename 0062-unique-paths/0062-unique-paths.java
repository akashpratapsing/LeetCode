class Solution {
    public int uniquePaths(int m, int n) {
        
     int[][] dp = new int[m][n];
     for (int[] arr : dp){
        Arrays.fill(arr, -1);
     }
     return uniquePathHelper(m - 1, n - 1, dp);
    }

    public int uniquePathHelper(int m, int n, int[][] dp) {
        
        if (m == 0 && n == 0){
            return 1;
        }

        if (m < 0 || n < 0){
            return 0;
        }

        if (dp[m][n] != -1){
            return dp[m][n];
        }

        int up = uniquePathHelper(m - 1, n, dp);
        int left = uniquePathHelper(m, n - 1, dp);

        return dp[m][n] = up + left;
    }
}
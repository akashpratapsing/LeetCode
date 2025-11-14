class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++){
            
            for (int j = 0; j < n; j++){
                int d = matrix[i][j] + dp[i - 1][j];

                int dl = matrix[i][j];
                if (j - 1 >= 0) dl += dp[i - 1][j - 1];
                else dl += 10000;

                int dr = matrix[i][j];
                if (j + 1 < n) dr += dp[i - 1][j + 1];
                else dr += 10000;

                dp[i][j] = Math.min(d, Math.min(dr, dl));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

}
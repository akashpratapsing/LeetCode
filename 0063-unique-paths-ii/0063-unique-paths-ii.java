class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(obstacleGrid, m - 1, n - 1, dp);
        
    }

     public int helper(int[][] arr, int m, int n, int[][] dp){

            if (m == 0 && n == 0 && arr[m][n] == 0){
                return 1;
            }

            if (m < 0 || n < 0){
                return 0;
            }

            if (arr[m][n] == 1){
                return 0;
            }

            if (dp[m][n] != -1){
                return dp[m][n];
            }

            int up = helper(arr, m - 1, n, dp);
            int left = helper(arr, m, n - 1, dp);

            return dp[m][n] = up + left;
        }
}
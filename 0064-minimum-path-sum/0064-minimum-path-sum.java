class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(grid, m - 1, n - 1, dp);
        
    }

    public int helper(int[][] grid, int m, int n, int[][] dp){

        if (m == 0 && n == 0) return grid[0][0];

        if (m < 0 || n < 0) return Integer.MAX_VALUE;

        if (dp[m][n] != -1){
            return dp[m][n];
        }

        int up = helper(grid, m - 1, n, dp);
        int left = helper(grid, m, n - 1, dp);

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }
}
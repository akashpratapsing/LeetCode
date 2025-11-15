class Solution {
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
		int[][][] dp = new int[n][m][m];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                if (i == j){
                    dp[n - 1][i][j] = grid[n - 1][i];
                }else {
                    dp[n - 1][i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--){

            for (int j1 = 0; j1 < m; j1++){
                for (int j2 = 0; j2 < m; j2++){

                    int max = (int) -1e8;
                    for (int d1 = -1; d1 <= 1; d1++){
                        for (int d2 = -1; d2 <= 1; d2++){
                            int value = 0;
                            if (j1 == j2){
                                value = grid[i][j1];
                            }else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            
                            if (j1 + d1 < 0 || j1 + d1 >= m || j2 + d2 < 0 || j2 + d2 >= m ){        
                                value += (int) -1e8;
                            }else {
                                value += dp[i + 1][j1 + d1][j2 + d2];
                            }
                            max = Math.max(max, value);
			              }
                        }
                        dp[i][j1][j2] = max;
                    }
                }
            }
        
		return dp[0][0][m - 1];
        
    }
  
}
class Solution {
    public int cherryPickup(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
		int[][][] dp = new int[r][c][c];
		for (int[][] a : dp){
			for (int[] b : a){
			   Arrays.fill(b, -1);
			}
		}
		return helper(grid, r, c, 0, 0, c - 1, dp);
        
    }
    public static int helper(int[][] grid, int r, int c, int i, int j1, int j2, int[][][] dp){

		if (i >= r || j1 < 0 || j1 >= c || j2 < 0 || j2 >= c ){
			return (int) -1e8;
		}

		if (i == r - 1) {
			if (j1 == j2){
				return grid[i][j1];
			}else {
				return grid[i][j1] + grid[i][j2];
			}
		}

		if (dp[i][j1][j2] != -1){
			return dp[i][j1][j2];
		}

		int max = (int) -1e8;
		for (int x = -1; x <= 1; x++){
			for (int y = -1; y <= 1; y++){
			if (j1 == j2){
			max =  Math.max(max, grid[i][j1] + helper(grid, r, c, i + 1, j1 + x, j2 + y, dp));
			}else {
			max =  Math.max(max, grid[i][j1] + grid[i][j2] + helper(grid, r, c, i + 1, j1 + x, j2 + y, dp));
			}
			}
		}
		return dp[i][j1][j2] = max;
	}
}
class Solution {

    public void dfs(int row, int col, int[][] grid, boolean[][] visited){
        visited[row][col] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                !visited[nRow][nCol] && grid[nRow][nCol] == 1){
                    dfs(nRow, nCol, grid, visited);
                }
        }
    }
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        // Boundary Rows
        for (int i = 0; i < m; i++){
            if (!visited[0][i] && grid[0][i] == 1){
                dfs(0, i, grid, visited);
            }

            if (!visited[n - 1][i] && grid[n - 1][i] == 1){
                dfs(n - 1, i, grid, visited);
            }
        }

        // Boundary Col
         for (int i = 0; i < n; i++){

            if (!visited[i][0] && grid[i][0] == 1){
                dfs(i, 0, grid, visited);
            }

            if (!visited[i][m - 1] && grid[i][m - 1] == 1){
                dfs(i, m - 1, grid, visited);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
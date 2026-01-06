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

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1){
                    dfs(i, j, grid, visited);
                }
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
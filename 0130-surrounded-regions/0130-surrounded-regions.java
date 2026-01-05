class Solution {
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        
        visited[row][col] = true;
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++){
            
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                !visited[nRow][nCol] && grid[nRow][nCol] == 'O'){
                    dfs(nRow, nCol, grid, visited);
                }
        }
    }

    public void solve(char[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        
        for (int i = 0; i < m; i++){
            
            if (!visited[0][i] && grid[0][i] == 'O'){
                dfs(0, i, grid, visited);
            }
            
            if (!visited[n - 1][i] && grid[n - 1][i] == 'O'){
                dfs(n - 1, i, grid, visited);
            }
        }
        
        for (int i = 0; i < n; i++){
            
            if (!visited[i][0] && grid[i][0] == 'O'){
                dfs(i, 0, grid, visited);
            }
            
            if (!visited[i][m - 1] && grid[i][m - 1] == 'O'){
                dfs(i, m - 1, grid, visited);
            }
        }
        
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j] && grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
    }
}
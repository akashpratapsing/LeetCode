class Solution {

    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;

        int n = grid.length;
        int m = grid[0].length;

        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(grid, visited, newRow, newCol);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
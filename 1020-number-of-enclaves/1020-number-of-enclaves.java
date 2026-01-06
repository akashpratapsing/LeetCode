class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1){
                    visited[i][j] = true;
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                !visited[nRow][nCol] && grid[nRow][nCol] == 1){
                    visited[nRow][nCol] = true;
                    q.offer(new int[] {nRow, nCol});
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
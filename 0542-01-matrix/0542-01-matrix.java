class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 0){
                    visited[i][j] = true;
                    q.offer(new int[] {i, j, 0});
                }
            }
        }
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!q.isEmpty()){
            
            int row = q.peek()[0];
            int col = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            dist[row][col] = d;
            for (int i = 0; i < 4; i++){
                
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    !visited[nRow][nCol]){
                        visited[nRow][nCol] = true;
                        q.offer(new int[] {nRow, nCol, d + 1});
                    }
            }
        }
        return dist;
    }
}
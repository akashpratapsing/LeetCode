class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cntFresh = 0;
        Queue<int[]> q = new LinkedList<>();

        // Marking Visited
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                if (grid[i][j] == 2){
                    q.offer(new int[] {i , j, 0});
                    vis[i][j] = 2;
                }else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) cntFresh++;
            }
        }

        int time = 0;
        int cnt = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        // BFS
        while (!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int t = q.peek()[2];
            q.poll();

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++){

                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                        q.offer(new int[]{nRow, nCol, time + 1});
                        vis[nRow][nCol] = 2;
                        cnt++;
                    }
            }
        }

        if (cnt != cntFresh) return -1;
        return time;
    }

    
}
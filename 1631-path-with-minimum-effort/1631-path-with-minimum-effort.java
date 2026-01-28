class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] a: dist){
            Arrays.fill(a, (int) 1e9);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, 0, 0});

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()){
            int dis = q.peek()[0];
            int row = q.peek()[1];
            int col = q.peek()[2];
            q.poll();

            if (row == n - 1 && col == m - 1) return dis;

            for (int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m){

                        int currDiff = Math.max(Math.abs(heights[nRow][nCol] - heights[row][col]), dis);
                        if (currDiff < dist[nRow][nCol]){
                            dist[nRow][nCol] = currDiff;
                            q.offer(new int[] {currDiff, nRow, nCol});
                        }
                        
                    }
            }
        }
        return 0; 
    }
}
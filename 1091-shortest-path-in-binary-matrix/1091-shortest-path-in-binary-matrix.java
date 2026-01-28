class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1)
            return -1;

        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] a : dist) {
            Arrays.fill(a, (int) 1e9);
        }
        dist[0][0] = 1;

        int[] dRow = { -1, -1, -1, 1, 1, 1, 0, 0 };
        int[] dCol = { -1, 0, 1, -1, 0, 1, -1, 1 };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 1, 0, 0 });

        while (!q.isEmpty()) {
            int row = q.peek()[1];
            int col = q.peek()[2];
            int dis = q.peek()[0];
            q.poll();

            if (row == n - 1 && col == n - 1){
                return dis;
            }

            for (int i = 0; i < 8; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n &&
                        grid[nRow][nCol] == 0 && dis + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = dis + 1;
                    q.offer(new int[] { dis + 1, nRow, nCol });
                }
            }
        }
        return -1;
    }
}
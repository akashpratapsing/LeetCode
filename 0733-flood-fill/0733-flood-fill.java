class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        dfs(sr, sc, image, ans, color, iniColor, dRow, dCol);
        return ans;
    }

    public void dfs(int row, int col, int[][] image, int[][] ans, int color, int iniColor, int[] dRow, int[] dCol){

        ans[row][col] = color;

        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++){

            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                && image[nRow][nCol] == iniColor && ans[nRow][nCol] != color){
                    dfs(nRow, nCol, image, ans, color, iniColor, dRow, dCol);
                }
        }
    }
}
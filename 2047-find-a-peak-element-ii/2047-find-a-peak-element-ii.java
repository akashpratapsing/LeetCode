class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int start = 0;
        int end = m - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            int maxIndex = findMaxInColumn(mat, mid, n);
            int left = (mid - 1 >= 0) ? mat[maxIndex][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[maxIndex][mid + 1] : -1;

            if (mat[maxIndex][mid] > left && mat[maxIndex][mid] > right){
                return new int[]{maxIndex, mid};
            }else if (mat[maxIndex][mid] < left){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
        
    }

    public int findMaxInColumn(int[][] mat, int col, int row){

        int max = -1;
        int maxValue = -1;

        for (int i = 0; i < row; i++){
            if (mat[i][col] > maxValue){
                maxValue = mat[i][col];
                max = i;
            }
        }
        return max;
    }
}
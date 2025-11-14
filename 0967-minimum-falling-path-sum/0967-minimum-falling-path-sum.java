class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int i = 0; i < n; i++){
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++){
            
            for (int j = 0; j < n; j++){
                int d = matrix[i][j] + prev[j];

                int dl = matrix[i][j];
                if (j - 1 >= 0) dl += prev[j - 1];
                else dl += 10000;

                int dr = matrix[i][j];
                if (j + 1 < n) dr += prev[j + 1];
                else dr += 10000;

                curr[j] = Math.min(d, Math.min(dr, dl));
            }
            prev = curr.clone();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(min, prev[i]);
        }
        return min;
    }

}
class Solution {

    public int f(int i, int j, String word1, String word2, int[][] dp) {

        if (i == 0) return j;
        if (j == 0) return i;
        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1))
            return dp[i][j] = f(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = 1 + Math.min(f(i - 1, j, word1, word2, dp),
                Math.min(f(i, j - 1, word1, word2, dp),
                        f(i - 1, j - 1, word1, word2, dp)));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f(n, m, word1, word2, dp);
    }
}
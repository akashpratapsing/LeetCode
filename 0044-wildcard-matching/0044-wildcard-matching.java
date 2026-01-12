class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            boolean flag = true;
            for (int j = 1; j <= i; j++) {
                if (p.charAt(j - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (p.charAt(i - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                else
                    dp[i][j] = false;
            }
        }

        return dp[m][n];
    }
}
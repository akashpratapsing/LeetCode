class Solution {
    public int f(int[] nums, int ind, int prev, int[][] dp){

        if (ind == nums.length) return 0;
        if (dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int len = f(nums, ind + 1, prev, dp);
        if (prev == -1 || nums[prev] < nums[ind]) {
            len = Math.max(len, 1 + f(nums, ind + 1, ind, dp));
        }
        return dp[ind][prev + 1] = len;
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return f(nums, 0, -1, dp);
    }
}
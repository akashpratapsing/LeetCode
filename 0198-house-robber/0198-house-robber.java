class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            int rob = nums[i] + dp[i - 2];
            int dontRob = dp[i - 1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[n - 1];

    }

}
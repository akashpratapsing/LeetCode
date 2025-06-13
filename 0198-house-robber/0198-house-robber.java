class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1, dp);
        
    }

    public int rob(int[] nums, int idx, int[] dp){

        if (idx == 0){
            return nums[idx];
        }

        if (idx < 0){
            return 0;
        }

        if (dp[idx] != -1){
            return dp[idx];
        }

        int rob = nums[idx] + rob(nums, idx - 2, dp);
        int dontRob = 0 + rob(nums, idx - 1, dp);

        return dp[idx] = Math.max(rob, dontRob);
    }
}
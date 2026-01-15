class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        // int[] hash = new int[n];
        Arrays.fill(dp, 1);
        // Arrays.fill(hash, -1);
        int maxInd = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int prev = 0; prev < i; prev++){

                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    // hash[i] = prev;
                }
            }
            max = Math.max(max, dp[i]);
            // if (nums[i] > max){
            //     maxInd = i;
            //     max = nums[i];
            // }
        }
       
        return max;
    }
}
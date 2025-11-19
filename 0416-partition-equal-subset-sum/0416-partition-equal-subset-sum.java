class Solution {
    public boolean canPartition(int[] nums) {
         
         int totalSum = 0;
         for (int n : nums){
            totalSum += n;
         }

         if (totalSum % 2 != 0){
            return false;
         }

         return helper(nums, totalSum/2);
    }

    public boolean helper(int[] nums, int sum){

        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if (nums[0] <= sum){
            prev[nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++){
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;

            for (int target = 1; target <= sum; target++){
                boolean notTake = prev[target];
                boolean take = false;
                if (nums[i] <= target){
                    take = prev[target - nums[i]];
                }
                curr[target] = take || notTake;
            }
            prev = curr;
        }
        return prev[sum];
    }
}
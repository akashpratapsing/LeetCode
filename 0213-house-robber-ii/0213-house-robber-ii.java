class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        
    }

    public int rob(int[] nums, int start, int end){

        int prev2 = 0, prev = 0;

        for (int i = start; i <= end; i++){
            int curr = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = curr;
        }

        return prev;

    }
}
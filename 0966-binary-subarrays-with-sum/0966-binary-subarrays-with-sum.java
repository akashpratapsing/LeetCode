class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return count(nums, goal) - count(nums, goal - 1);
    }

    public int count(int[] nums, int goal){

        if (goal < 0) return 0;

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length){
            sum += nums[right];

            while (sum > goal && left <= right){
                sum -= nums[left];
                left++;
            }

            if (sum <= goal){
                count += (right - left + 1);
            }
            right++;
        }

        return count;
    }
}
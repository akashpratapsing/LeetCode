class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MIN_VALUE;

        while (start <= end){

            int mid = start + (end - start) / 2;

            ans = nums[mid];

            if (nums[start] <= nums[mid] && nums[end] <= nums[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }

        }

        return ans;
        
    }
}
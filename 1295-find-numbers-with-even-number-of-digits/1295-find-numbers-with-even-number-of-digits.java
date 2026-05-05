class Solution {
    public int findNumbers(int[] nums) {

        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            int element = (int) Math.log10(nums[i]) + 1;

            if (element % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
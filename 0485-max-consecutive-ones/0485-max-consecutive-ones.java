class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int currOnes = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++){
            currOnes = (nums[i] == 1) ? ++currOnes : 0;
            max = Math.max(max, currOnes);
        }

        return max;
        
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int len = next[prev + 1];
                if (prev == -1 || nums[prev] < nums[ind]) {
                    len = Math.max(len, 1 + next[ind + 1]);
                }
                curr[prev + 1] = len;
            }
            next = curr;
        }
        return next[0];
    }
}
class Solution {
    public int jump(int[] nums) {

        int l = 0, r = 0, jumps = 0;

        while (r < nums.length - 1){

            int fIdx = 0;
            for (int i = l; i <= r; i++){
                fIdx = Math.max(fIdx, i + nums[i]);
            }

            l = r + 1;
            r = fIdx;
            jumps++;
        }
        return jumps;
    }

}
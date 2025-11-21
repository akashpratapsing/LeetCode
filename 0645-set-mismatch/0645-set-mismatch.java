class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2];
        boolean[] seen = new boolean[n + 1];

        for (int i : nums){
            if (seen[i]){
                ans[0] = i;
            }
            seen[i] = true;
        }

        for (int i = 1; i <= n; i++){
            if(!seen[i]){
                ans[1] = i;
                break;
            }
        }
    
        return ans;
    }
}
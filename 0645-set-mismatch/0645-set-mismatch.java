class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2];
        boolean[] seen = new boolean[n + 1];
        int sum = 0;

        for (int i : nums){
            if (seen[i]){
                ans[0] = i;
            }else {
                seen[i] = true;
                sum += i;
            }
            
        }

        ans[1] = ((n * (n + 1)) /2) - sum;
    
        return ans;
    }
}
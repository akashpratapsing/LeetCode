class Solution {
    public int[] countBits(int n) {
        
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++){
            memo[i] = (i & 1) + memo[i / 2];
        }
        return memo;
    }
}
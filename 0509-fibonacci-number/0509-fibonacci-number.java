class Solution {
    public int fib(int n) {
        
        if (n == 0 || n == 1) return n;
        
        int prev1 = 0, prev = 1;
        for (int i = 2; i <= n; i++){
            int temp = prev1 + prev;
            prev1 = prev;
            prev = temp;
        }
        return prev;
    }
}
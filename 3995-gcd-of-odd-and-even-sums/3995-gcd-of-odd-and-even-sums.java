class Solution {
    public int gcdOfOddEvenSums(int n) {

        int odd = n * n;
        int even = n * (n + 1);

        return gcd(odd, even);
    }

    public int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
}
class Solution {
    public int pivotInteger(int n) {

        int totalSum = (n * (n + 1)) / 2;

        for (int i = 1; i <= n; i++){

            int sum = (i * (i + 1)) / 2;
            int otherHalf = totalSum - sum + i;
            if (sum == otherHalf){
                return i;
            }
        }
        return -1;
    }
}
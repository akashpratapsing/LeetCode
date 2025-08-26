class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int l = 0;
        int r = cardPoints.length - 1;
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;

        while (l < k){
            lSum += cardPoints[l];
            l++;
        }
        l--;
        maxSum = lSum;

        while (l >= 0 && l != r){
            lSum -= cardPoints[l];
            rSum += cardPoints[r];
            maxSum = Math.max(maxSum, lSum + rSum);
            l--;
            r--;
        }

        return maxSum;
        
    }
}
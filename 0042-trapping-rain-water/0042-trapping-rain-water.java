class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }
        int[] suffMax = new int[n];
        suffMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMax[i] = Math.max(height[i], suffMax[i + 1]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = preMax[i], rightMax = suffMax[i];
            total += Math.min(leftMax, rightMax) - height[i];
        }
        return total;
    }
}
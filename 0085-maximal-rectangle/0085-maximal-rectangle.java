class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = (matrix[i][j] == '1') ? height[j] + 1 : 0;
            }
            max = Math.max(max, getMaxArea(height));
        }
        return max;
    }

    public int getMaxArea(int[] height) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && height[st.peek()] > height[i]) {
                int nse = i;
                int ele = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = (nse - pse - 1) * height[ele];
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = n;
            int ele = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = (nse - pse - 1) * height[ele];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
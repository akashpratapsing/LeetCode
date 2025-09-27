class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        // Next Smaller to Left;
        int[] pse = new int[n];
        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Next Smaller to Right;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--){
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, (nse[i] - pse[i] - 1) * heights[i]);
        }
        return max;
    }
}
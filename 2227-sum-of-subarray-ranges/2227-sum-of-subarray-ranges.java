class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        // Next Smaller to Left 
        int[] nextSmallerToLeft = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            nextSmallerToLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Next Smaller to Right 
        int[] nextSmallerToRight = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nextSmallerToRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        // Next Greater to Left 
        int[] nextGreaterToLeft = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            nextGreaterToLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Next Greater to Right 
        int[] nextGreaterToRight = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nextGreaterToRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        long smallest = 0, largest = 0;
        for (int i = 0; i < n; i++){
            smallest += (long) (i - nextSmallerToLeft[i]) * (nextSmallerToRight[i] - i) * nums[i];
            largest += (long) (i - nextGreaterToLeft[i]) * (nextGreaterToRight[i] - i) * nums[i];
        }
        return largest - smallest;
    }
}
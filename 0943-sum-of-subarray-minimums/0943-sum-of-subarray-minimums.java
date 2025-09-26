class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] nse = nextSmaller(arr, n);
        int[] pse = previosSmaller(arr, n);
        int mod = (int)1e9 + 7;
        long answer = 0;

       for (int i = 0; i < n; ++i) {
            int left = i - pse[i];
            int right = nse[i] - i;
            answer += (long) left * right % mod * arr[i] % mod;
            answer %= mod;
        }
        return (int) answer;
    }

    public int[] nextSmaller(int[] arr, int n){

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--){

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

        public int[] previosSmaller(int[] arr, int n){

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){

            while (!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}
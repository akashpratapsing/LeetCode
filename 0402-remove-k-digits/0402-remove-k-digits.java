class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {

            char ch = num.charAt(i);
            while (k > 0&& !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while (k != 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String res = sb.substring(i);
        return res.isEmpty() ? "0" : res;

    }
}
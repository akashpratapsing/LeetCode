class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++){

            if (tokens[i].equals("+") || tokens[i].equals("-") || 
            tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                st.push(operation(num1, num2, tokens[i]));
            }else {
                st.push(tokens[i]);
            }
        }

        return Integer.parseInt(st.pop());   
    }

    public String operation(int num1, int num2, String op){
        int ans= 0;
        if (op.equals("+")){
            ans = num1 + num2;
        }else if (op.equals("-")){
            ans = num1 - num2;
        }else if (op.equals("*")){
            ans = num1 * num2;
        }else {
            ans = num1 / num2;
        }
        return Integer.toString(ans);
    }

}
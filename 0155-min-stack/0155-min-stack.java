class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        if (st.isEmpty()){
            st.push((long)val);
            min = val;
        } else if (min > val){
            st.push(2L * val - min);
            min = val;
        }else {
            st.push((long) val);
        }
    }
    
    public void pop() {
        
        long x = st.pop();
        if (min > x){
            min = 2 * min - x;
        }
    }
    
    public int top() {
        long top = st.peek();
        if (min < top){
            return (int) top;
        }
        return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class StockSpanner {

    Stack<Integer[]> st;
    int index;

    public StockSpanner() {
        this.st = new Stack<>();
        this.index = -1;
    }
    
    public int next(int price) {
        index += 1;

        while (!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }

        int ans = index - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new Integer[] {price, index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
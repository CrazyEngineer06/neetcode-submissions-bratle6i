class MinStack {
    Stack<Integer> st;
    Stack<Integer> pref;
    public MinStack() {
        st = new Stack<>();
        pref = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        if(pref.isEmpty()){
            pref.push(val);
        }else{
            if(val <= pref.peek()){
                pref.push(val);
            }
        }
    }
    
    public void pop() {
        int n = st.pop();
        if(n == pref.peek()){
            pref.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(pref.isEmpty()) return 0;
        return pref.peek();
    }
}

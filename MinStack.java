class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
     
    }

    public void push(int val) {
        if(minStack.size() == 0 || minStack.peek() >= val){
            minStack.push(val);
        }
        st.push(val);
    }

    public void pop() {
        int currTop = -1;
        if(!st.isEmpty()){
            currTop = st.pop();
        }
        if(!minStack.isEmpty() && minStack.peek() == currTop){
            minStack.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

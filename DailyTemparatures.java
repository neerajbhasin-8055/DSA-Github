class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for(int i = n-1 ; i >=0 ; i--){
                                    //current value   // stack top 
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            res[i] = (!st.isEmpty()) ? st.peek() - i : 0;
            st.push(i);
        }
        return res;
    }
}
 
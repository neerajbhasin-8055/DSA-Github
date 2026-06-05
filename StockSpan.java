import java.util.*;
class StockSpan{
    private Stack<int[]> st;
    public StockSpan(){
        st = new Stack<>();
    }

    public int next(int price){
        int span = 1; 
        while(!st.isEmpty() && st.peek()[0] <= price){
            span += st.pop()[1];
        }
        st.push(new int[]{price,span});
        return span;
    }

    public static void main(String[] args){
        
    }
}
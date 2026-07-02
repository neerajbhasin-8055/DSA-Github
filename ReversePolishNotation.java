class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> st = new Stack<>();
        int result = 0 ;
        for(String s : tokens){
            if(set.contains(s)){
                int a = st.pop();
                int b = st.pop();
                result = switch(s){
                    case "+" -> b+a;
                    case "-" -> b-a;
                    case "/" -> b/a;
                    case "*" -> b*a;
                    default -> throw new IllegalArgumentException();
                };
                st.push(result);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}

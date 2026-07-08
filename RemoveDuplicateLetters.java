class Solution {
    public String removeDuplicateLetters(String s) {
        int[]freq = new int[26];
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            freq[ch-'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(char ch : charArray){
            freq[ch - 'a']--;
            if(st.contains(ch)){
                continue;
            }
            while(!st.isEmpty() && ch <= st.peek() && freq[st.peek() - 'a'] > 0){
                st.pop();
            }
            
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
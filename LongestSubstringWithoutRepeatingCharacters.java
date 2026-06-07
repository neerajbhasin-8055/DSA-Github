import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters{
    public int lswrc(String s){
        Set<Character> st = new HashSet<>();
        int i = 0 ;
        int j = 0 ;
        int maxLen = 0;
        while(j<s.length()){
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            st.add(s.charAt(j));
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        String sp = s.trim();
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0 ;i<sp.length();i++){
            char ch = sp.charAt(i);
            if(Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }else if(Character.isDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int i = 0 ;
        int j = sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
class ProcessStringWithSpecialOperations{
   
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }else if(ch == '#'){
                sb.append(sb.toString());
            }else if(ch == '%'){
                sb.reverse();
            }else if(ch == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }
                
            }
        }
    return sb.toString();
    }
}

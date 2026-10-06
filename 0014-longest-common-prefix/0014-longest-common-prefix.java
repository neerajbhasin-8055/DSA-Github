class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str = strs[0];
        String str2 = strs[strs.length-1];
        StringBuilder prefix = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) != str2.charAt(i)){
                break;
            }
            prefix.append(str.charAt(i));
        }
        return prefix.toString();
    }
}
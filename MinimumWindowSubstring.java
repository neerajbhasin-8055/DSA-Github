class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int n = s.length();
        int m = t.length();
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int left = 0 ;
        int right = 0 ;
        int req = m;
        int min = Integer.MAX_VALUE;
        int start = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(freq[ch] > 0){
                req--;
            }
            freq[ch]--;
            while(req == 0){
                if(right-left+1 < min){
                    min = right -left + 1;
                    start = left;
                }
                char c = s.charAt(left);
                freq[c]++;
                if(freq[c] > 0){
                    req++;
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start+min);
    }
}

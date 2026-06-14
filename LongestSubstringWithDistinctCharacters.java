import java.util.*;

class LongestSubstringWithDistinctCharacters {
    public static int longestSubstringWithDistKCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        ;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char key = s.charAt(left);
                int count = map.getOrDefault(key, 0) - 1;
                map.put(key, count);
                if (count <= 0) {
                    map.remove(key);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcddefg";
        int k = 3;
        int res = longestSubstringWithDistKCharacters(s, k);
        System.out.println(res);
    }
}
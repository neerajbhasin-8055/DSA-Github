class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        int cnt = 0;
        while (freq[1] >= 1 && freq[0] >= 1 && freq[11] >= 2 && freq[14] >= 2 && freq[13] >= 1) {
            cnt++;
            freq[1]--;
            freq[0]--;
            freq[11] -= 2;
            freq[14] -= 2;
            freq[13]--;

        }
        return cnt;
    }

}
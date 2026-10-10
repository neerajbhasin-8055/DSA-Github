class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currProfit = 0;
            if (prices[i] > lp) {
                currProfit = prices[i] - lp;
            }
            lp = prices[i];
            max = Math.max(currProfit, max + currProfit);
        }
        return max;
    }
}
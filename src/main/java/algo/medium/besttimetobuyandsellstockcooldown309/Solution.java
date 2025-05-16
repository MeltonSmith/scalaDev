package r.ian.algo.medium.besttimetobuyandsellstockcooldown309;


/**
 * @author Melton Smith
 * @since 16.05.2025
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int cash = 0, prevCash = 0;
        for (int i = 0; i < prices.length; i++) {
            int cashOld = cash;

            cash = Math.max(cash, hold + prices[i]);
            hold = Math.max(hold, prevCash - prices[i]);
            //if we're going to buy on the day ith, then we should compare with prev cash
            prevCash = cashOld;
        }
        return cash;
    }
}

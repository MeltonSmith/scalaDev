package r.ian.algo.medium.besttimetobuyandsellstockfee714;

import static java.lang.Math.max;

/**
 * @author Melton Smith
 * @since 14.05.2025
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;
        for (int i = 1; i < prices.length; i++) {
            cash = max(cash, hold + prices[i] - fee);
            hold = max(hold, cash - prices[i]);
        }
        return cash;
    }
}

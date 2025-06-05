package r.ian.algo.medium.besttimetobuyandsellstock122;

import static java.lang.Math.max;

/**
 * @author Melton Smith
 * @since 05.06.2025
 */
public class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;
        for (int i = 1; i < prices.length; i++) {
            int cashOld = cash;
            cash = max(cash, hold + prices[i]);
            hold = max(hold, cashOld - prices[i]);
        }
        return cash;
    }
}

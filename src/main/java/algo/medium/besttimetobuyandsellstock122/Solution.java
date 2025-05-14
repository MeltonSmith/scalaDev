package r.ian.algo.medium.besttimetobuyandsellstock122;

/**
 * @author Melton Smith
 * @since 14.05.2025
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int tendency = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff <= 0) {
                if (tendency >= 0) {
                    profit += tendency; //sell point
                    tendency = diff;
                } else
                    tendency += diff; //keep tendency
            }
            if (diff > 0) {
                if (tendency >= 0)
                    tendency += diff; //keep tendency point
                else
                    tendency = diff; //buy point
            }

        }
        if (tendency > 0)
            profit += tendency;
        return profit;
    }
}

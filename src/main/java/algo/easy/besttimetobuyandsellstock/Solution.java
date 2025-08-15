package r.ian.algo.easy.besttimetobuyandsellstock;

/**
 * @author Melton Smith
 * @since 06.05.2025
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int min = -1, diff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min || min == -1)
                min = prices[i];
            if (prices[i] - min > diff)
                diff = prices[i] - min;

        }
        return diff;

//        also
        // int havingBalance= -prices[0];
        // int sellingBalance = 0;

        // for (int i = 1; i < prices.length; i++) {
        //     sellingBalance = Math.max(sellingBalance, havingBalance + prices[i]);
        //     havingBalance = Math.max(havingBalance, -prices[i]);
        // }

        // return sellingBalance;
    }


}

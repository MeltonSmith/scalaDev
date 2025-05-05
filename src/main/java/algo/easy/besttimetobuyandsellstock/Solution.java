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
    }
}

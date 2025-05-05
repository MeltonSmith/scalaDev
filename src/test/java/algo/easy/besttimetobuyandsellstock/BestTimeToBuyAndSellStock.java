package r.ian.algo.easy.besttimetobuyandsellstock;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 06.05.2025
 */
public class BestTimeToBuyAndSellStock {
    @Test
    public void firstTest() {
        Solution s = new Solution();
//        var result = s.maxProfit(new int[]{7,1,5,3,6,4});
        var result = s.maxProfit(new int[]{2,1,2,1,0,1,2});
        System.out.println(result);
    }
}

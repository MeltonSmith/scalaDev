package r.ian.algo.medium.besttimetobuyandsellstock122;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 14.05.2025
 */
public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(solution.maxProfit(new int[]{6,1,3,2,4,7}));

    }
}

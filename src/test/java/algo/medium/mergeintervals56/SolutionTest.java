package r.ian.algo.medium.mergeintervals56;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 29.05.2025
 */
public class SolutionTest {

    @Test
    public void firstTest() {
//        int[][] case1  = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] case1  = new int[][] {{1, 4}, {4, 5}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(case1);
        System.out.println(merge);

    }
}

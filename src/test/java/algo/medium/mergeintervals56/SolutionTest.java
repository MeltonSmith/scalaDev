package r.ian.algo.medium.mergeintervals56;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 29.05.2025
 */
public class SolutionTest {

    @Test
    public void firstTest() {
        int[][] case1  = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] case1  = new int[][] {{1, 4}, {4, 5}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(case1);
        System.out.println(merge);

    }

    @Test
    public void secondTest() {
        int[][] case1  = new int[][] {{1, 4}, {0, 4}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(case1);
        System.out.println(merge);

    }

    @Test
    public void thirdTest() {
        int[][] case1  = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(case1);
        System.out.println(merge);

    }
    @Test
    public void forthTest() {
        int[][] case1  = new int[][] {{5,5}, {1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(case1);
        System.out.println(merge);
    }
}

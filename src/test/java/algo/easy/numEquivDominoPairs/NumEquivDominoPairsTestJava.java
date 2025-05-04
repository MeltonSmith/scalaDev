package r.ian.algo.easy.numEquivDominoPairs;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 04.05.2025
 */

public class NumEquivDominoPairsTestJava {

    @Test
    public void firstTest() {
        Solution s = new Solution();
        var result = s.numEquivDominoPairs1(new int[][]{{1,2},{1,2}, {1,1},{1,2},{2,2}});
//        var result = s.numEquivDominoPairs(new int[][]{{1,1}, {1,2}, {1,3}, {1,4}, {1,6}, {2,2} ,{2,3}, {2,4}, {2,5}, {2,6}, {3,3}, {3,4}, {3,5}, {3,6},{4,5},{4,6}, {5,5}, {5,6}, {6,6}});
        System.out.println(result);
    }

    @Test
    public void secondTest() {
        Solution s = new Solution();
        var result = s.numEquivDominoPairs(new int[][]{{1,2},{2,1}, {3,4},{5,6}});
        System.out.println(result);
    }

    @Test
    public void thirdTest() {
        Solution s = new Solution();
//        var result = s.numEquivDominoPairs(new int[][]{[[2,1],[5,4],[3,7],[6,2],[4,4],[1,8],[9,6],[5,3],[7,4],[1,9],[1,1],[6,6],[9,6],[1,3],[9,7],[4,7],[5,1],[6,5],[1,6],[6,1],[1,8],[7,2],[2,4],[1,6],[3,1],[3,9],[3,7],[9,1],[1,9],{8,9}]});
//        System.out.println(result);
    }
}

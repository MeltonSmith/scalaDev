package r.ian.algo.medium.search2dmatrix;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 29.04.2025
 */
public class Search2dMatrixTest {
    @Test
    public void firstTest() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(solution.searchMatrix(matrix, 23));
    }


}

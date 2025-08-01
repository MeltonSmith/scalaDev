package r.ian.algo.medium._73;

/**
 * @author Melton Smith
 * @since 01.08.2025
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroinFirstCol = false;

        for (int i = 0; i < matrix.length; i++ ) {
            if (matrix[i][0] == 0) zeroinFirstCol = true;
            for (int j = 1; j < matrix[i].length; j++ ) {
                if (matrix[i][j]== 0) {
                    matrix[0][j] =0; //vertical mark
                    matrix[i][0] =0; //horizontal mark
                }

            }
        }
        //reverse traversing
        for (int i = matrix.length-1; i >= 0; i-- ) {
            for (int j = matrix[i].length-1; j>=1; j-- ) {
                if (matrix[i][0]== 0 || matrix[0][j]== 0) {
                    matrix[i][j]= 0;
                }

            }
            if (zeroinFirstCol) {
                matrix[i][0] = 0;
            }
        }


    }
}

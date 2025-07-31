package r.ian.algo.easy._1572;

/**
 * @author Melton Smith
 * @since 31.07.2025
 */
public class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int j = i;
            int z = mat[i].length - i - 1;

            if (j == z) { //middle
                sum += mat[i][j];
                continue;
            }
            sum += mat[i][j];
            sum += mat[i][z];

        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] multi = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(new Solution().diagonalSum(multi));
    }
}



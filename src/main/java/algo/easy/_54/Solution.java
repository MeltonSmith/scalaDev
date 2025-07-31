package r.ian.algo.easy._54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melton Smith
 * @since 01.08.2025
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        List<Integer> result = new LinkedList<>();

        while (left <= right && top <= bottom) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3,4}, {5, 6, 7 ,8}, {9, 10, 11,12}}));
    }
}

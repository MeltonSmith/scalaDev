package r.ian.algo.medium.search2dmatrix;

/**
 * @author Melton Smith
 * @since 29.04.2025
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int leftOutside = 0, rightOutside = matrix.length - 1;
        while (leftOutside <= rightOutside) {
            int mid = leftOutside + (rightOutside - leftOutside) / 2;
            if (matrix[mid][0] == target)
                return true;

            if (matrix[mid][0] > target) {
                if (matrix[mid][matrix[mid].length-1] > target)
                    rightOutside = mid - 1;
                else
                    return search(matrix[mid], target);

            }
            if (matrix[mid][0] < target) {
                if (matrix[mid][matrix[mid].length-1] < target)
                    leftOutside = mid + 1;
                else
                    return search(matrix[mid], target);

            }
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < target)
                left = mid + 1;
            if (nums[mid] > target)
                right = mid - 1;

        }
        return false;
    }
}

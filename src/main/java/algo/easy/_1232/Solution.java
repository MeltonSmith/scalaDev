package r.ian.algo.easy._1232;

/**
 * @author Melton Smith
 * @since 07.08.2025
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        double dx = x1 - x0;
        double dy = y1 - y0;
        for (int i = 2; i < coordinates.length; i++) {
            if (dx * (coordinates[i][1]-y1) != dy * (coordinates[i][0]-x1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}}));
//        System.out.println(new Solution().checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
        System.out.println(new Solution().checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));

    }
}



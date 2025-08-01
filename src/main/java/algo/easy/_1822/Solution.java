package r.ian.algo.easy._1822;

/**
 * @author Melton Smith
 * @since 29.07.2025
 */
public class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0)
                return 0;

            if (num < 0) {
                res *= -1;
            }
        }
        return res;
    }
}

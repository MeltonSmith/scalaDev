package r.ian.algo.easy.evennumberofdigits;

/**
 * @author Melton Smith
 * @since 30.04.2025
 */
public class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int i = 0;
            while (num != 0){
                num /= 10;
                i++;
            }
            if (i % 2 == 0)
                res ++;
        }
        return res;
    }
}

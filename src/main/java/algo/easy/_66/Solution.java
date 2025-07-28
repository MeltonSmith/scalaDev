package r.ian.algo.easy._66;

import java.util.Arrays;

/**
 * @author Melton Smith
 * @since 28.07.2025
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int r = 1;
        for (int i = digits.length-1; i>=0; i--) {
            int res = digits[i] + r;
            if (res >= 10) {
                digits[i] = res % 10;
            }
            else {
                digits[i] = res;
                r = 0;
                break;
            }
        }
        if (r != 0) {
            int[] result = new int[digits.length+1];
            result[0] = r;
            for (int i = 0;i< digits.length; i++){
                result[i+1] = digits[i];
            }
            return result;
        }
        else {
            return digits;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
    }
}

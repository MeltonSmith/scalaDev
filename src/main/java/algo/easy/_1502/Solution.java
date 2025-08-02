package r.ian.algo.easy._1502;

import java.util.Arrays;

/**
 * @author Melton Smith
 * @since 02.08.2025
 */
public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff =  Math.abs(arr[1] - arr[0]);
        for (int i =1, j =2; j < arr.length; i++,j++) {
            if (Math.abs(arr[j] - arr[i]) != diff) {
                return false;
            }
        }

        return true;
    }
}

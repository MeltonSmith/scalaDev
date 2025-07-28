package r.ian.algo.easy._283;

import java.util.Arrays;

/**
 * @author Melton Smith
 * @since 28.07.2025
 */
public class Solution {
    public void moveZeroesReverted(int[] nums) {
        int j = 0;
        // int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j++;
            } else {
                int k = i - j; //starting position where non zero values "chunk" starts
                int temp = nums[k];
                nums[k] = 0;
                for (j--; j >= 0; j--) {
                    k = i - j;
                    int temp2 = nums[k];
                    nums[k] = temp;
                    temp = temp2;
                }
                j = 0;

            }
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0; //index for a possible non zero placement
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package r.ian.algo.easy._26;

/**
 * @author Melton Smith
 * @since 10.08.2025
 */
public class Solution {
    //59% 91%
    public int removeDuplicates(int[] nums) {
        int indexToSet = 1;
        int prevValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prevValue) {
                if (i != indexToSet) {
                    nums[indexToSet] = nums[i];
                }
                prevValue = nums[i];
                indexToSet++;
            }
        }
        return indexToSet;
    }

    public int removeDuplicates2(int[] nums) {
        int indexToSet = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[indexToSet-1]) {
                nums[indexToSet++] = nums[i];
            }
        }
        return indexToSet;
    }
}

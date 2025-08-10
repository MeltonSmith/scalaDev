package r.ian.algo.medium._80;

/**
 * @author Melton Smith
 * @since 10.08.2025
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int indexToSet = 1;
        byte currentElemCapacity = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[indexToSet-1]) {
                nums[indexToSet] = nums[i];
                currentElemCapacity = 1;
                indexToSet++;
            } else {
                if (currentElemCapacity !=2) {
                    nums[indexToSet] = nums[i];
                    currentElemCapacity++;
                    indexToSet++;
                }
            }
        }
        return indexToSet;
    }
}

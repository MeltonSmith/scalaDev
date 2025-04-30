package r.ian.algo.medium.searchinrotatedsortedarray;

/**
 * @author Melton Smith
 * @since 30.04.2025
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftValue = nums[left], rightValue = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentValue = nums[mid];
            if (currentValue == target) {
                return mid;
            }
            if (currentValue < target) {
                if (target >= leftValue && target > nums[right]) {
                    if (mid != nums.length - 1 && nums[mid+1] > target)
                        return -1;
//                    rotated need to look in a left part
                    right = mid - 1;
                    continue;
                }
                left = mid + 1;
            }
            if (currentValue > target) {
                if (target <= rightValue && target > nums[left]) {
                    if (mid != 0 && nums[mid-1] < target)
                        return -1;
                    //rotated need to look in a right part
                    left = mid + 1;
                    continue;
                }
                right = mid - 1;
            }
        }
        return -1;
    }
}

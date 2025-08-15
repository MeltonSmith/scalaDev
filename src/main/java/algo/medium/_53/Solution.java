package r.ian.algo.medium._53;

/**
 * @author Melton Smith
 * @since 16.08.2025
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxEnding = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            https://www.geeksforgeeks.org/dsa/largest-sum-contiguous-subarray/
            //checking if the current array needs to be extended
            //if maxEnding + nums[i] becomes less we "start a new array"
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            //updating result
            res = Math.max(maxEnding, res);
        }
        return res;
    }
}

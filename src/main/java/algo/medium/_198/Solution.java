package r.ian.algo.medium._198;

/**
 * @author Melton Smith
 * @since 16.08.2025
 * 198. House Robber
 */
public class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0], nums[1]);
        }

        //2 states
        //0 - Robbing (can be robbin with i-1 day or i-2 day), take from state NotRobbing of i-1 and i-2 days
        //1 - Not Robbing(take from state number 0 from [i-1] day and [i-2] days)
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < nums.length; i++ ){
            dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]);
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}

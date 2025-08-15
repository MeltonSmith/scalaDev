package r.ian.algo.easy._70;

/**
 * @author Melton Smith
 * @since 15.08.2025
 */
public class Solution {
    public int climbStairs(int n) {
        //1 1
        //2 1+1 or 2
        //3 1+1+1 1+2 2+ 1
        //4 1+1+1+1 1+2+1 2+1+1 1+1+2 2+2
        int[] dp =  new int[45];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i<n; i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}

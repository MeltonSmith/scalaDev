package r.ian.algo.medium.dominoandtrilinotiling790;

/**
 * @author Melton Smith
 * @since 06.05.2025
 */
public class Solution {

    public int numTilings(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (int)((2L * dp[i-1] + dp[i-3]) % 1_000_000_007);
        }
        return dp[n];
    }

    public int numTilings1(int n) {
        int maxThrees = n / 3;
        int[][] dp = new int[n+1][maxThrees+1];
        dp[0][0] = 1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j <= Math.min(i/3+1, maxThrees); j++) {
                if (j <= maxThrees) {
                    dp[i][j] += dp[i-1][j];
                }

                if (i >= 2 && j <= maxThrees) {
                    dp[i][j] += dp[i-2][j];
                }
                if (i >= 3 && j > 0) {
                    dp[i][j] += dp[i-3][j-1];
                }
            }
        }

        int res = dp[n][0];

        for (int i = 1; i <= Math.min(i/3+1, maxThrees); i++) {
            // 0000 1111 0001 0010 0100 1000  1100 1010 1001 0101 0011 0110 1011 1101 1110 0111 = (2)^number of trominos
            res += Math.pow(2, dp[n][i]);
        }
        return res % 1_000_000_007;

    }


}

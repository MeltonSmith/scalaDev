package r.ian.algo.easy._1672;

/**
 * @author Melton Smith
 * @since 31.07.2025
 */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {

            int currWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                currWealth += accounts[i][j];
            }
            if (currWealth > maxWealth){
                maxWealth = currWealth;
            }
        }
        return maxWealth;
    }
}

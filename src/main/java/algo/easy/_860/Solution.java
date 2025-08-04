package r.ian.algo.easy._860;

/**
 * @author Melton Smith
 * @since 04.08.2025
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int price = 5;
        int[] onHandBills = new int[2];
        int m = onHandBills.length;
        for (int bill: bills) {
            if (bill == price) {
                onHandBills[bill%m]++;
            } else {
                int diff = (bill - price);
                while (onHandBills[10%m] > 0 && diff >= 10) {
                    diff = diff - 10;
                    onHandBills[10%m]--;
                }

                while (onHandBills[5%m] > 0 && diff >= 5) {
                    diff = diff - 5;
                    onHandBills[5%m]--;
                }

                if (diff != 0) {
                    return false;
                }
                else {
                    if (bill != 20) //i dont need to track 20s
                        onHandBills[bill%m]++; //accept bill
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
    }
}

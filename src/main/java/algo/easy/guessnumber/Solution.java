package r.ian.algo.easy.guessnumber;

/**
 * @author Melton Smith
 * @since 28.04.2025
 */

public class Solution {
    /**
     * Forward declaration of guess API.
     *
     * @param n your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            var result = guess(mid);
            if (result == 0) return mid;
            if (result == -1)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    private int guess(int num) {
        return 0;
    }
}

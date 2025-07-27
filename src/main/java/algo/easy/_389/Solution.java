package r.ian.algo.easy._389;

/**
 * @author Melton Smith
 * @since 27.07.2025
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int xor = 0;
        for (char chr : s.toCharArray()) {
            xor ^= chr;
        }
        for (char chr : t.toCharArray()) {
            xor ^= chr;
        }
        return (char) xor;
    }
}

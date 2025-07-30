package r.ian.algo.easy._58;

/**
 * @author Melton Smith
 * @since 30.07.2025
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() -1; i >-1; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                else {
                    return count;
                }

            }
            count ++;
        }
        return count;

    }
}

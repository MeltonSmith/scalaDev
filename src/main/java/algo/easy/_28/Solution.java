package r.ian.algo.easy._28;

/**
 * @author Melton Smith
 * @since 27.07.2025
 */
public class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();


        for (int i = 0, j = 0; i < n; ) {
            if (j == 0 && i + m > n) {
                return -1;
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if (j == needle.length())
                    return i - j;
            } else {
                i = i - j + 1;
                j = 0;


            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}

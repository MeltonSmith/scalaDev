package r.ian.algo.easy.validanagram242;

/**
 * @author Melton Smith
 * @since 27.05.2025
 */
public class Solution {

    public static void main(String[] args) {
        boolean anagram = isAnagram("cat", "rat");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i) + i ^ a;
            b = t.charAt(i) + i ^ b;
        }


        int i = a ^ b;
        return i == 0;

    }
}

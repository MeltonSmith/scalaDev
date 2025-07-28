package r.ian.algo.easy._459;

/**
 * @author Melton Smith
 * @since 28.07.2025
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length()-1);
        return sub.contains(s);
    }
}

package r.ian.algo.hard.longestsubsequencerepeatedktimes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Melton Smith
 * @since 01.07.2025
 */
public class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {

        int maxSegmentLength = s.length() / k;

        char[] charArray = s.toCharArray();
        int[] charascii2 = new int[26];

        for (int i = 0; i < charArray.length; i++) {
            charascii2[charArray[i] - 'a']++;
        }

        List<Character> charCandidates = new ArrayList<>();

        for (int i = 0; i < charascii2.length; i++) {
            if (charascii2[i] >= k) {
                charCandidates.add((char) (i + 'a'));
            }
        }

        String result = "";
        Queue<String> queue = new ArrayDeque<>();
        queue.add(result);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (int i = 0; i < charCandidates.size(); i++) {
                //segment is too long
                if (maxSegmentLength < curr.length() + 1)
                    break;

                var next = curr + charCandidates.get(i);
                if (isAPartOf(next, s, k)) {
                    result = next;
                    queue.add(next);
                }
            }
        }

        return result;

    }

    /**
     * if a substr is a part of s
     */
    public boolean isAPartOf(String subStr, String s, int k) {
        int i = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == subStr.charAt(i)) {
                i++;
                if (i == subStr.length()) {
                    i = 0;
                    count++;
                    if (count == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String res = new Solution().longestSubsequenceRepeatedK("letsleetcode", 2);
        System.out.println(res);
    }
}

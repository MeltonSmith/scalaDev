package r.ian.algo.medium._3;

/**
 * @author Melton Smith
 * @since 16.08.2025
 * 3. Longest Substring Without Repeating Characters
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] freq = new int[126];
        for (int i = 0, currentLength = 0, substrStartIndex = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c]++;
            if (freq[c] == 2){
                maxLength = Math.max(maxLength, currentLength);
                while (true) { //sliding 1 index further
                    char c1 = s.charAt(substrStartIndex);
                    freq[c1]--;
                    substrStartIndex++;
                    if (c1 == c) { //finding the beginning of the next interval (the came char)
                        currentLength = i - substrStartIndex + 1; //resetting the length
                        break;
                    }

                }
            } else {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }
}

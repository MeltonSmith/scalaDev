package r.ian.algo.medium.LongestBinarySubseqLessThan2311;

/**
 * @author Melton Smith
 * @since 30.06.2025
 */
public class Solution {
    public static int longestSubsequence(String s, int k) {

        char[] charArray = s.toCharArray();
        int rhsLength = 0;
        int lhsLength = 0;
        String binaryString = Integer.toBinaryString(k);
        int significantBitPos = binaryString.length();

        int bitShift = 0;
        int sum = 0;
        for (int i = charArray.length - 1, j = 0; i >= 0; i--, j++) {
            if (j <= significantBitPos - 1) {
                if (charArray[i] == '1') {
                    int sum1 = 1 << bitShift;
                    if (sum1 + sum <= k) {
                        sum += sum1;
                        rhsLength++;
                        bitShift += 1;
                    }
                    //else do nothing
                }
                else {
                    rhsLength++;
                    bitShift += 1;
                }
            }
            else {
                if (charArray[i] == '0') {
                    lhsLength++;
                }
            }
        }
        return rhsLength + lhsLength;
    }

    public static void main(String[] args) {
        int i = longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101", 11713332);
    }
}

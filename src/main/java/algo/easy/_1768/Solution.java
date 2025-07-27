package r.ian.algo.easy._1768;

/**
 * @author Melton Smith
 * @since 27.07.2025
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        char[] resultCharArray = new char[word1.length()+word2.length()];
        int currentIndex = 0;



        while (i < word1.length() && j < word2.length()) {
            resultCharArray[currentIndex] = word1.charAt(i);
            i++;
            currentIndex++;
            resultCharArray[currentIndex] = word2.charAt(j);
            j++;
            currentIndex++;
        }

        while (i < word1.length()) {
            resultCharArray[currentIndex] = word1.charAt(i);
            i++;
            currentIndex++;
        }

        while (j < word2.length()) {
            resultCharArray[currentIndex] = word2.charAt(j);
            j++;
            currentIndex++;
        }

        return String.valueOf(resultCharArray);
    }
}
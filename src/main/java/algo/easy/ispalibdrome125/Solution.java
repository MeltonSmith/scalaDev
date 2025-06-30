package r.ian.algo.easy.ispalibdrome125;

/**
 * @author Melton Smith
 * @since 30.06.2025
 */
class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        do {
            if (!Character.isLetterOrDigit(arr[i])){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[j])){
                j--;
                continue;
            }

            if (Character.toLowerCase(arr[j]) == Character.toLowerCase(arr[i])){
                if (i == j || i == j -1)
                    return true;
                i++;
                j--;

            }
            else {
                return false;
            }
        } while (i <= j);
        return true;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("ab2a");
    }
}
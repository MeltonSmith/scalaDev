package r.ian.algo.easy._67;

/**
 * @author Melton Smith
 * @since 09.08.2025
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

       while (i >= 0 || j >= 0 || carry > 0) {
           int sum = carry;
           if (i >=0) sum += a.charAt(i--) - '0';
           if (j >=0) sum += b.charAt(j--) - '0';

           sb.append(sum % 2);
           carry = sum / 2;
       }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}

package r.ian.algo.medium._43;

import java.util.*;

/**
 * @author Melton Smith
 * @since 01.08.2025
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int result = 0;

        String n1 = num1.length() > num2.length() ? num1 : num2;
        String n2 = num1.length() > num2.length() ? num2 : num1;

        ArrayList<LinkedList<Byte>> chars = new ArrayList<>();

        if (n2.length() == 1 && n2.charAt(0) == '0') {
            return "0";
        }

        for (int i = n2.length() - 1, e = 0; i >= 0; i--, e++) { //should be lowerNumber
            LinkedList<Byte> sb = new LinkedList<>();
            byte dec = 0;
            for (int j = n1.length() - 1; j >= 0; j--) { //should be higherNumber
                int s1 = Character.getNumericValue(n2.charAt(i));
                int s2 = Character.getNumericValue(n1.charAt(j));
                int res = s1 * s2 + dec;
                dec = 0;
                byte lastDigit = (byte) (res % 10);
                sb.addFirst(lastDigit);
                if (res >= 10) {
                    dec += (byte) (res / 10);
                }
            }

            if (dec != 0) {
                sb.addFirst(dec);
            }

            for (int i1 = 0; i1 < e; i1++) {
                sb.addLast((byte) 0);
            }
            chars.add(sb);
        }

        Optional<LinkedList<Byte>> reduce = chars.stream().reduce(
                (a, b) -> {
                    int dec = 0;
                    LinkedList<Byte> product = new LinkedList<>();
                    while (a.peekLast() != null && b.peekLast() != null) {
                        byte first = a.pollLast();
                        byte second = b.pollLast();

                        byte res = (byte) (first + second + dec);
                        dec = 0;
                        if (res >= 10) {
                            byte i = (byte) (res % 10);
                            product.addFirst(i);
                            dec = res / 10;
                        } else {
                            product.addFirst(res);
                        }

                    }

                    while (a.peekLast() != null) {
                        byte first = a.pollLast();
                        byte res = (byte) (first + dec);
                        dec = 0;
                        if (res >= 10) {
                            byte i = (byte) (res % 10);
                            product.addFirst(i);
                            dec = res / 10;
                        } else {
                            product.addFirst(res);
                        }

                    }
                    while (b.peekLast() != null) {
                        byte second = b.pollLast();
                        byte res = (byte) (second + dec);
                        dec = 0;
                        if (res > 10) {
                            byte i = (byte) (res % 10);
                            product.addFirst(i);
                            dec = res / 10;
                        } else {
                            product.addFirst(res);
                        }
                    }


                    if (dec != 0) {
                        product.addFirst((byte) dec);
                    }
                    return product;
                }
        );


        return reduce.map(a -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (a.peekFirst() != null) {
                        byte first = a.pollFirst();
                        stringBuilder.append(first);
                    }
                    return stringBuilder.toString();
                }
        ).orElse("");

    }


    public String multiply2(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mlt = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                int pos1 = i + j;
                int pos2 = pos1 + 1;
                int sum = mlt + res[pos2];

                res[pos2] = (sum) % 10;
                res[pos1] += sum / 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : res)
            if(!(sb.isEmpty() && p == 0))
                sb.append(p);
        return sb.isEmpty() ? "0" : sb.toString();

    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().multiply2("173", "284"))); //56088
        System.out.println((new Solution().multiply2("284", "173"))); //49132
    }
}

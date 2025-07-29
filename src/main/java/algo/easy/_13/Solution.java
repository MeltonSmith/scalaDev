package r.ian.algo.easy._13;

import java.util.List;
import java.util.Map;

/**
 * @author Melton Smith
 * @since 29.07.2025
 */
public class Solution {

    enum RomanSign {

        I ('I', 1),
        V('V',5),
        X('X',10),
        L('L',50),
        C('C',100),
        D('D',500),
        M('M',1000);

        final char sign;
        final int decimalValue;

        RomanSign(char sign, int decimalValue) {
            this.sign = sign;
            this.decimalValue = decimalValue;
        }

    }

    public RomanSign defineEnum(char n) {
        return switch (n) {
            case 'I' -> RomanSign.I;
            case 'V' -> RomanSign.V;
            case 'X' -> RomanSign.X;
            case 'L' -> RomanSign.L;
            case 'C' -> RomanSign.C;
            case 'D' -> RomanSign.D;
            case 'M' -> RomanSign.M;
            default -> null;
        };
    }



    public int romanToInt(String s) {
        char[] input = s.toCharArray();
        int res =  defineEnum(input[0]).decimalValue;
        for (int i = 1; i < input.length; i++) {
            res += defineEnum(input[i]).decimalValue;
            if (defineEnum(input[i-1]).compareTo(defineEnum(input[i])) < 0 ) {
                res -= 2* defineEnum(input[i-1]).decimalValue;
            }

        }
        return res;
    }
}

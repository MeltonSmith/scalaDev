package r.ian.algo.easy._13;

import java.util.List;
import java.util.Map;

/**
 * @author Melton Smith
 * @since 29.07.2025
 */
public class Solution {

    private List<Character> chars = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');
    private Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        char[] input = s.toCharArray();
        int res = map.get(input[0]);
        for (int i = 1; i < input.length; i++) {
            res += map.get(input[i]);
            if (chars.indexOf(input[i-1]) < chars.indexOf(input[i])) {
                res -= 2* map.get(input[i-1]);
            }

        }
        return res;
    }
}

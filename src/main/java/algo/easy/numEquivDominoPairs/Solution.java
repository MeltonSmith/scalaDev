package r.ian.algo.easy.numEquivDominoPairs;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Melton Smith
 * @since 04.05.2025
 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>(dominoes.length, 1);
        for (int[] domino : dominoes) {
            int key = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            integerIntegerHashMap.compute(key, (k,v) ->  v == null ? 1 : v + 1);
        }

        return integerIntegerHashMap.values().stream().filter(integer -> integer > 1)
                .map(value -> value * (value - 1) / 2)
                .reduce(0, Integer::sum);
    }

    public int numEquivDominoPairs1(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}

package r.ian.algo.medium.mergeintervals56;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 86% 84%
 *
 * @author Melton Smith
 * @since 29.05.2025
 */
public class Solution3 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] > next[0]) {
                current[1] = Math.max(next[1], current[1]);
            }
            else {
                mergedIntervals.add(current);
                current = next;
            }
        }

        mergedIntervals.add(current);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}

package r.ian.algo.medium.minimumdominorotations;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Melton Smith
 * Greedy problem
 * @since 03.05.2025
 */
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length == 0 || bottoms.length == 0) {
            return -1;
        }
        var topCandidate = tops[0];
        var bottomCandidate = bottoms[0];
        int rotateCountForTopOnTop = 0;
        int rotateCountForBottomOnBottom = 0;
        int rowCountForTopWithTopOnTop = 0;
        int rowCountForBottomWithBottomOnBottom = 0;

        int rotateCountForTopOnBottom = 1;
        int rotateCountForBottomOnTop = 1;
        int rowCountForTopWithTopOnBottom = 0;
        int rowCountForBottomWithBottomOnTop = 0;



        final int score = tops.length - 1;

        for (int i = 1; i < tops.length; i++) {
            if ((topCandidate != tops[i] && topCandidate != bottoms[i]) && (bottomCandidate != bottoms[i] && bottomCandidate != tops[i])) {
                return -1;
            }

            //bottom as bottom
            if (bottomCandidate == bottoms[i]) {
                rowCountForBottomWithBottomOnBottom++;
            } else if (bottomCandidate == tops[i]) {
                rotateCountForBottomOnBottom++;
                rowCountForBottomWithBottomOnBottom++;
            }


            //bottom as top
            if (bottomCandidate == tops[i]) {
                rowCountForBottomWithBottomOnTop++;
            } else if (bottomCandidate == bottoms[i]) {
                rotateCountForBottomOnTop++;
                rowCountForBottomWithBottomOnTop++;
            }

            //top as a bottom
            if (topCandidate == bottoms[i]) {
                rowCountForTopWithTopOnBottom++;
            } else if (topCandidate == tops[i]) {
                rotateCountForTopOnBottom++;
                rowCountForTopWithTopOnBottom++;
            }


            //top as top
            if (topCandidate == tops[i]) {
                rowCountForTopWithTopOnTop++;
            } else if (topCandidate == bottoms[i]) {
                rotateCountForTopOnTop++;
                rowCountForTopWithTopOnTop++;
            }
        }

        Optional<int[]> min = Stream.of(new int[]{rowCountForTopWithTopOnTop, rotateCountForTopOnTop},
                        new int[]{rowCountForBottomWithBottomOnBottom, rotateCountForBottomOnBottom},
                        new int[]{rowCountForTopWithTopOnBottom, rotateCountForTopOnBottom},
                        new int[]{rowCountForBottomWithBottomOnTop, rotateCountForBottomOnTop}
                ).filter(a -> a[0] == score)
                .min(Comparator.comparingInt(a -> a[1]));

        return min.map(ints -> ints[1]).orElse(-1);
    }
}

package r.ian.algo.easy._1275;

import java.util.BitSet;

/**
 * @author Melton Smith
 * @since 09.08.2025
 */
public class Solution {

    public String tictactoe(int[][] moves) {

        BitSet bs1 = fromBigEndianPositions(new int[]{1, 2, 3}, 8);
        BitSet bs2 = fromBigEndianPositions(new int[]{4, 5, 6}, 8);
        BitSet bs3 = fromBigEndianPositions(new int[]{7, 8, 9}, 8);
        BitSet bs4 = fromBigEndianPositions(new int[]{1, 4, 7}, 8);
        BitSet bs5 = fromBigEndianPositions(new int[]{2, 5, 8}, 8);
        BitSet bs6 = fromBigEndianPositions(new int[]{3, 6, 9}, 8);
        BitSet bs7 = fromBigEndianPositions(new int[]{1, 5, 9}, 8);
        BitSet bs8 = fromBigEndianPositions(new int[]{3, 5, 7}, 8);


        BitSet[] bss = new BitSet[]{bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8};

        BitSet aBitSet = new BitSet(moves.length / 2 + 1);
        BitSet bBitSet = new BitSet(moves.length / 2 + 1);

        for (int mn = 0; mn < moves.length; mn++) {
            var move = moves[mn];
            int x = move[0];
            int y = move[1];
            int pos = (x * 3) + (y + 1);
            if (mn % 2 == 0) {
                aBitSet.set(pos);
            } else {
                bBitSet.set(pos);
            }
        }
        var aWins = false;
        var bWins = false;


        for (int i = 0; i < bss.length; i++) {
            aWins = bss[i].stream().allMatch(aBitSet::get);
            bWins = bss[i].stream().allMatch(bBitSet::get);
            if (aWins || bWins){
                return aWins ? "A" : "B";
            }
        }

        if (moves.length == 9) {
            return "Draw";
        }
        else {
            return "Pending";
        }
    }


    public BitSet fromBigEndianPositions(int[] positions, int totalBits) {
        BitSet bs = new BitSet(totalBits);
        for (int pos : positions) {
            // Convert big-endian position to little-endian index
//            int reversedIndex = totalBits - 1 - pos;
            bs.set(pos);
        }
        return bs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2,1}, {2,2}}));
    }
}

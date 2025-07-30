package r.ian.algo.easy._1041;

import java.text.DecimalFormat;

/**
 * @author Melton Smith
 * @since 30.07.2025
 */
public class Solution {

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int angle = 90; //start facing north

        for (int i = 0; i < instructions.length(); i++){
            char comm = instructions.charAt(i);
            switch (comm) {
                case 'G' -> {
                    x =  x + (int) Math.cos(Math.toRadians(angle));
                    y =  y + (int) Math.sin(Math.toRadians(angle));
                }
                case 'L' -> angle += 90;
                case 'R' -> angle -= 90;
            }
        }
        return x == 0 && y == 0 || (int) Math.sin(Math.toRadians(angle)) != 1;
    }

    public static void main(String[] args) {
        boolean gg = new Solution().isRobotBounded("LGR");
    }
}

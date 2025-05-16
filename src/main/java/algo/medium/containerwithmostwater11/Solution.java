package r.ian.algo.medium.containerwithmostwater11;

/**
 * @author Melton Smith
 * @since 17.05.2025
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i != j) {
            int lhs = height[i];
            int rhs = height[j];
            int diff = Math.min(lhs, rhs);
            int area = diff * (j - i);
            if (area > maxArea)
                maxArea = area;
            //moving the pointer which points to the lower lvl
            if (lhs >= rhs)
                j--;
            else
                i++;

        }
        return maxArea;
    }
}

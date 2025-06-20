package r.ian.algo.easy.firstbadversion278;

/**
 * @author Melton Smith
 * @since 06.06.2025
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else{
                left = mid +1;
            }
        }
        return left;

    }

    boolean isBadVersion(int version) {
        return version < 0;
    }
}

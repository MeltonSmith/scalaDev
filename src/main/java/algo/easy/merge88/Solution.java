package r.ian.algo.easy.merge88;

/**
 * @author Melton Smith
 * @since 06.06.2025
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end_idx = nums1.length-1;
        while (n > 0 && m > 0) {
            if (nums2[n-1] >= nums1[m-1]) {
                nums1[end_idx]=nums2[n-1];
                n--;
            }
            else {
                nums1[end_idx]=nums1[m-1];
                m--;
            }
            end_idx--;
        }
        while (n > 0){
            nums1[end_idx]=nums2[n-1];
            n--;
            end_idx--;
        }
    }
}

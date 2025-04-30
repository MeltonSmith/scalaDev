package r.ian.algo.medium.searchinrotatedsortedarray;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 30.04.2025
 */
public class SearchInRotatedSortedArray {

    @Test
    public void firstTest() {
        Solution solution = new Solution();
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
//        int[] nums = new int[]{3,1};
        int search = solution.search(nums, 8);
        System.out.println(search);
    }
}

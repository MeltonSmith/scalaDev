package r.ian.algo.medium._287;

/**
 * @author Melton Smith
 * @since 16.08.2025
 * 287. Find the Duplicate Number
 */
public class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        //loop detected
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //we need to find the beggining of the loop
        //2(A+B) = A+B+C+D
        //setting fast to be as slow as tortoise
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

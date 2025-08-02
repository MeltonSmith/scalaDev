package r.ian.algo.medium._445;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 02.08.2025
 */
public class AddTwoNumbers2Test {


    @Test
    public void addTwoNumbers() {
        System.out.println(new Solution().addTwoNumbers(createListNodeFrom(7, 2, 4, 3), createListNodeFrom(5, 6, 4)));
    }







    private static ListNode createListNodeFrom(Integer... ints) {
        ListNode currentNode = null;

        for (int i = ints.length - 1; i >= 0; i--) {
            currentNode = new ListNode(ints[i], currentNode);
        }
        return currentNode;
    }
}

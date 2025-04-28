package r.ian.algo.medium.addtwonumbers;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 28.04.2025
 */
public class AddTwoNumbersTestsJava {

    @Test
    public void firstTest() {
        Solution solution = new Solution();
        var result = solution.addTwoNumbers(createListNodeFrom(2, 4, 3), createListNodeFrom(5, 6, 4 ));
        System.out.println(result);
    }

    @Test
    public void secondTest() {
        Solution solution = new Solution();
        var result = solution.addTwoNumbers(createListNodeFrom(0), createListNodeFrom(0));
        System.out.println(result);
    }

    @Test
    public void thirdTest() {
        Solution solution = new Solution();
        var result = solution.addTwoNumbers(createListNodeFrom(9,9,9,9,9,9,9), createListNodeFrom(9,9,9,9));
        System.out.println(result);
    }

    private static ListNode createListNodeFrom(Integer... ints) {
        ListNode currentNode = null;

        for (int i = ints.length - 1; i >= 0; i--) {
            currentNode = new ListNode(ints[i], currentNode);
        }
        return currentNode;
    }
}

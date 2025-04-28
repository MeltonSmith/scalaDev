package r.ian.algo.easy.reversedlinkedlist;


import org.junit.Test;

/**
 * @author Melton Smith
 * @since 28.04.2025
 */
public class ReversedLinkedListTest {

    @Test
    public void firstTest() {
        Solution solution = new Solution();
        var result = solution.reverseList(createListNodeFrom(1,2,3,4));
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

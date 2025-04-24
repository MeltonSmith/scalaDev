package r.ian.algo.hard.mergekSortedLists;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 24.04.2025
 */
public class MergeKSortedListsTestsJava {

    @Test
    public void firstTest(){
       ListNode[] listNodes = {createListNodeFrom(1,4,5), createListNodeFrom(1,3,4),  createListNodeFrom(2,6)};
        var result = SolutionJava.mergeKLists(listNodes);
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

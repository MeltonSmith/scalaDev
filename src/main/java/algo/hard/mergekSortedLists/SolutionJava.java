package r.ian.algo.hard.mergekSortedLists;

import java.util.Arrays;

/**
 * @author Melton Smith
 * @since 16.04.2025
 */
public class SolutionJava {

    private static final int treshhold = 2;

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        else if (lists.length < treshhold){
            return lists[0];
        }
        else {
            int i = lists.length / treshhold;

            //divide
            var a1 = mergeKLists(Arrays.stream(lists, 0, i).toArray(ListNode[]::new));
            var a2 = mergeKLists(Arrays.stream(lists, i, lists.length).toArray(ListNode[]::new));

            //conquer
            return serialSort(a1, a2);
        }
    }

    private static ListNode serialSort(ListNode a1, ListNode a2) {
        if (a1 == null && a2 == null) {
            return null;
        }
        else if (a1 == null) {
            return a2;
        }
        else if (a2 == null) {
            return a1;
        }
        else {
            if (a1.val < a2.val) {
                a1.next = serialSort(a1.next, a2);
                return a1;
            }
            else  {
                a2.next = serialSort(a2.next, a1);
                return a2;
            }
        }

    }
}

package r.ian.algo.hard.mergekSortedLists;


/**
 * @author Melton Smith
 * @since 16.04.2025
 */
public class SolutionJava {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        else if (lists.length < 2){
            return lists[0];
        }
        return divide(lists, 0, lists.length-1);
    }

    public ListNode divide(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (l + r) / 2;
        //divide
        var a1 = divide(lists, l, mid);
        var a2 = divide(lists, mid + 1, r);

        //conquer
        return serialSort(a1, a2);
    }

    private  ListNode serialSort(ListNode a1, ListNode a2) {
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

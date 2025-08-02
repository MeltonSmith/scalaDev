package r.ian.algo.easy._21;

/**
 * @author Melton Smith
 * @since 02.08.2025
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2==null){
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        var minNode = list1.val > list2.val ? list2 : list1;
        var maxNode = list1.val > list2.val ? list1 : list2;

        minNode.next = mergeTwoLists(minNode.next, maxNode);

        return minNode;
    }
}

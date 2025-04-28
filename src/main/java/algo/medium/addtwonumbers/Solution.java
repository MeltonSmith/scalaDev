package r.ian.algo.medium.addtwonumbers;

/**
 * @author Melton Smith
 * @since 25.04.2025
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        return addNodes(l1, l2, 0);
    }

    private ListNode addNodes(ListNode l1, ListNode l2, int p) {
        if (l1 == null && l2 == null) {
            return p > 0 ? new ListNode(p) : null;
        }

        var lhsval = l1 == null ? 0 : l1.val;
        var rhsval = l2 == null ? 0 : l2.val;

        var sum = lhsval + rhsval + p;
        ListNode listNode = new ListNode(sum % 10);
        listNode.next = addNodes(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum >= 10 ? 1 : 0);
        return listNode;
    }
}

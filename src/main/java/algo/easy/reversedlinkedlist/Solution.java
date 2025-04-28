package r.ian.algo.easy.reversedlinkedlist;

/**
 * @author Melton Smith
 * @since 28.04.2025
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode listNode = reverseList(head.next, head);
        head.next = null;
        return listNode;
    }

    private ListNode reverseList(ListNode current, ListNode prev) {
        if (current == null) return prev;
        ListNode listNode = reverseList(current.next, current);
        current.next = prev;
        return listNode;
    }
}

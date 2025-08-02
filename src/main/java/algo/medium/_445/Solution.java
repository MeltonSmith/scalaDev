package r.ian.algo.medium._445;

/**
 * @author Melton Smith
 * @since 02.08.2025
 */
public class Solution {

    //works only with numbers of the same length
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = merge(l1, l2);
        if (result != null && result.val >= 10) {
            var node = new ListNode(result.val / 10);
            var newNextNode = new ListNode(result.val % 10);
            newNextNode.next = result.next;
            node.next = newNextNode;
            return node;
        }
        return result;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l2 == null && l1 == null) {
            return null;
        }
        if (l1.next == null && l2.next != null) {
            return merge(l1, l2.next);
        }
        if (l2.next == null && l1.next != null) {
            return merge(l1.next, l2);
        }

        var lhs = l1 == null ? 0 : l1.val;
        var rhs = l2 == null ? 0 : l2.val;

        var sum  = lhs + rhs;

        var nextNode = merge(l1.next, l2.next);

        if (nextNode != null && nextNode.val >= 10) {
            var node = new ListNode(sum + nextNode.val / 10);
            var newNextNode = new ListNode(nextNode.val % 10);
            newNextNode.next = nextNode.next;
            node.next = newNextNode;
            return node;
        }
        else {
            var node = new ListNode(sum);
            node.next = nextNode;
            return node;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var l1r = reverse(l1);
        var l2r = reverse(l2);

        return reverse(merge(l1r, l2r,0));
    }


    public ListNode reverse(ListNode l1) {
        if (l1 == null)
            return null;

        return swap(l1.next, l1);

    }

    public ListNode swap(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }

        ListNode node = swap(current.next, current);
        prev.next = current;
        current.next = null;
        return node;

    }


    public ListNode merge(ListNode l1, ListNode l2, int dec) {
        if (l2 == null && l1 == null) {
            return dec > 0 ? new ListNode(dec) : null;
        }

        var lhs = l1 == null ? 0 : l1.val;
        var rhs = l2 == null ? 0 : l2.val;

        var sum  = lhs + rhs + dec;

        var nextNode = merge(l1.next == null? null: l1.next, l2.next == null ? null : l2.next, sum /10);

        return new ListNode(sum % 10, nextNode);
    }

    public static void main(String[] args) {

    }
}

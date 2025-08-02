package r.ian.algo.medium._445;

import java.util.StringJoiner;

/**
 * @author Melton Smith
 * @since 25.04.2025
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        var buffer = new StringJoiner(", ", "[",  "]");
        buffer.add(String.valueOf(val));

        var nx = this.next;

        while (nx != null){
            buffer.add(String.valueOf(nx.val));
            nx = nx.next;
        }
        return buffer.toString();
    }

}

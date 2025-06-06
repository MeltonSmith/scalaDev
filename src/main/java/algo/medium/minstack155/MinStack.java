package r.ian.algo.medium.minstack155;

/**
 * @author Melton Smith
 * @since 06.06.2025
 */
public class MinStack {

    private Node root = null;

    public MinStack() {

    }

//    public void push(int val) {
//        if (root == null) {
//            root = new Node(val);
//            minNode = new Node(val);
//        } else {
//            var a = new Node(val);
//            a.next = root;
//            root = a;
//
//            var localCurrentMinNode = minNode;
//            var localCurrentMinNodeNext = minNode.next;
//            if (localCurrentMinNode.val > val){
//                Node newMin = new Node(val);
//                newMin.next = localCurrentMinNode;
//                minNode = newMin;
//                return;
//            }
//
//            while (localCurrentMinNode != null) {
//                localCurrentMinNodeNext = localCurrentMinNode.next;
//                if (localCurrentMinNode.val <= val && localCurrentMinNodeNext == null || localCurrentMinNode.val <= val && localCurrentMinNodeNext.val > val){
//                    Node newMin = new Node(val);
//                    newMin.next = localCurrentMinNodeNext;
//                    localCurrentMinNode.next = newMin;
//                    break;
//                }
//                localCurrentMinNode = localCurrentMinNode.next;
//            }
//        }
//    }

    public void push(int val) {
        if (root == null) {
            root = new Node(val, val);
        } else {
            var a = new Node(val);
            a.next = root;
            if (val < root.min)
                a.min = val;
            else
                a.min = root.min;

            root = a;
        }
    }

    public void pop() {
        root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        return root.min;
    }

    private static class Node {
        private final int val;
        private Node next;
        private int min;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.pop();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

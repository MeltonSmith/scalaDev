package r.ian.algo.easy.balancedbinarytree110;

/**
 * @author Melton Smith
 * @since 20.05.2025
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int i = dfsLeft(root.left);
        int j = dfsLeft(root.right);
        int abs = Math.abs(i - j);
        System.out.println("abs = " + abs);
        return i >= 0 && j >= 0 && (abs <=1);
    }

    public int dfsLeft(TreeNode node) {
        if (node == null)
            return 0;
        int i = 1+dfsLeft(node.left);
        int j = 1+dfsLeft(node.right);
        System.out.println("node with val " + node.val + " i is " + i + " j is " + j);
        if (Math.abs(i - j) > 1)
            return -5001;
        return Math.max(i, j);
    }
}

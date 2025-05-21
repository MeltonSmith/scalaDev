package r.ian.algo.easy.balancedbinarytree110;

/**
 * @author Melton Smith
 * @since 20.05.2025
 */
public class Solution {

    //100 72
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int i = dfsLeft(root.left);
        int j = dfsLeft(root.right);
        int abs = Math.abs(i - j);
        return i >= 0 && j >= 0 && (abs <= 1);
    }

    public int dfsLeft(TreeNode node) {
        if (node == null)
            return 0;
        int i = 1 + dfsLeft(node.left);
        int j = 1 + dfsLeft(node.right);
        if (Math.abs(i - j) > 1)
            return -5001;
        return Math.max(i, j);
    }

    //100 34
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsLeft(root) != -1;
    }

    public int dfsLeft1(TreeNode node) {
        if (node == null)
            return 0;
        int i = dfsLeft(node.left);
        if (i == -1) {
            return -1;
        }
        int j = dfsLeft(node.right);
        if (j == -1) {
            return -1;
        }
        if (Math.abs(i - j) > 1)
            return -1;


        return 1 + Math.max(i, j);
    }
}

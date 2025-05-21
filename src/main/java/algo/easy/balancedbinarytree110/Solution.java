package r.ian.algo.easy.balancedbinarytree110;

/**
 * @author Melton Smith
 * @since 20.05.2025
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {

        return dfsLeft(root) <=1;
    }

    public int dfsLeft(TreeNode node) {
        if (node == null)
            return 0;
//        if (node.left == null) {
//            return -1-dfsLeft(node.right);
//        }
        return dfsLeft(node.left)-dfsLeft(node.right);
    }



//    public int dfsDiff(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return Math.abs(dfsLeft(node) - dfsRight(node));
//    }



//    public int dfsRight(TreeNode node) {
//        if (node.right == null) {
//            return 0;
//        }
//        return 1 + dfsRight(node.right);
//    }
}

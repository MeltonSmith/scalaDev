package r.ian.algo.easy._104;

/**
 * @author Melton Smith
 * @since 06.08.2025
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return depthLfs(root);
    }

    public int depthLfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depthLfs(node.left) + 1; // depth of a left subtree
        int rightDepth = depthLfs(node.right) + 1; // depth of a right subtree

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}

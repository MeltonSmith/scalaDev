package r.ian.algo.easy.balancedbinarytree110;

import org.junit.Test;

/**
 * @author Melton Smith
 * @since 21.05.2025
 */
public class SolutionTest {

    @Test
    public void firstTest(){


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2)
                .setLeft(new TreeNode(4)
                        .setLeft(new TreeNode(8)))
                .setRight(new TreeNode(5));

        root.right = new TreeNode(3).setRight(new TreeNode(6));

        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        boolean expected = true;
    }
}

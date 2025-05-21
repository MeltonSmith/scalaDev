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

        root.right = new TreeNode(3)
                            .setRight(new TreeNode(6)
                                            .setRight(new TreeNode(7)
                                                            .setRight(new TreeNode(14))));

        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        boolean expected = true;
    }

    @Test
    public void case2Test(){


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2)
                .setLeft(new TreeNode(3)
                        .setLeft(new TreeNode(4))
                        .setRight(new TreeNode(4)))
                .setRight(new TreeNode(3));

        root.right = new TreeNode(2);

        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        boolean expected = true;
    }

    @Test
    public void case1Test(){


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20)
                        .setLeft(new TreeNode(15))
                .setRight(new TreeNode(7));

        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        boolean expected = true;
    }

    @Test
    public void case174Test(){


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2)
                .setLeft(new TreeNode(3).setLeft(new TreeNode(4)));

        root.right = new TreeNode(2)
                .setRight(new TreeNode(3).setRight(new TreeNode(4)));


        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        boolean expected = true;
    }
}

package r.ian.algo.medium.pathsumii113;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melton Smith
 * @since 23.05.2025
 */
public class SolutionTest {


    private Solution solution = new Solution();

    @Test
    public void firstCaseTest() {

        var node = new TreeNode(5)
                .setLeft(new TreeNode(4)
                        .setLeft(new TreeNode(11)
                                .setLeft(new TreeNode(7))
                                .setRight(new TreeNode(2))))
                .setRight(new TreeNode(8)
                            .setLeft(new TreeNode(13))
                            .setRight(new TreeNode(4)
                                            .setLeft(new TreeNode(5))
                                            .setRight(new TreeNode(1))
                                ));

        ArrayList<List<Integer>> res = new ArrayList<>();
        solution.dfsPathLookup(node, 22, res);
        System.out.println(res);
    }

    @Test
    public void secondCaseTest() {
        var node = new TreeNode(-2).setRight(new TreeNode(-3));
        ArrayList<List<Integer>> res = new ArrayList<>();
        solution.dfsPathLookup(node, -5, res);
        System.out.println(res);
    }
}

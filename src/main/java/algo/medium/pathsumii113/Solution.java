package r.ian.algo.medium.pathsumii113;

import java.util.*;

/**
 * @author Melton Smith
 * @since 22.05.2025
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfsPathLookup(root, targetSum, res);
        return res;
    }

    public List<Integer> dfsPathLookup(TreeNode node, int targetSumLeft, List<List<Integer>> res) {
        if (node == null) {
            return null;
        }
        if (targetSumLeft < node.val) {
            //go up and check another path
            return null;
        }
        if (targetSumLeft == node.val && node.left == null && node.right == null) { //leaf
            LinkedList<Integer> a = new LinkedList<>();
            a.addFirst(node.val);
            res.add(a);
            //return index
            List<Integer> idx = new ArrayList<>();
            idx.add(res.size()-1);
            return idx;
        }

        List<Integer> lPositions = dfsPathLookup(node.left, targetSumLeft - node.val, res);
        List<Integer> rPositions = dfsPathLookup(node.right, targetSumLeft - node.val, res);
        List<Integer> resultPositions;

        if (lPositions == null && rPositions == null) {
            return null;
        }
        else if (lPositions != null && rPositions != null) {
            lPositions.addAll(rPositions);
            resultPositions = lPositions;
        }
        else if (lPositions != null)
            resultPositions = lPositions;

        else
            resultPositions = rPositions;

        for (int i = resultPositions.size()-1; i >= 0; i--) {
            res.get(i).add(0, node.val);
        }

        return resultPositions;
    }
}
